/*
 * Copyright 2023 INOVA IT d.o.o.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 *  is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 *   BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.matejdro.anvil

import com.google.auto.service.AutoService
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.ExperimentalAnvilApi
import com.squareup.anvil.compiler.api.AnvilContext
import com.squareup.anvil.compiler.api.CodeGenerator
import com.squareup.anvil.compiler.api.GeneratedFile
import com.squareup.anvil.compiler.api.createGeneratedFile
import com.squareup.anvil.compiler.internal.buildFile
import com.squareup.anvil.compiler.internal.reference.ClassReference
import com.squareup.anvil.compiler.internal.reference.classAndInnerClassReferences
import com.squareup.anvil.compiler.internal.safePackageString
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import dagger.Module
import dagger.Provides
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.psi.KtFile
import java.io.File

@Suppress("unused")
@OptIn(ExperimentalAnvilApi::class)
@AutoService(CodeGenerator::class)
class DemoGenerator : CodeGenerator {
    override fun generateCode(
        codeGenDir: File,
        module: ModuleDescriptor,
        projectFiles: Collection<KtFile>
    ): Collection<GeneratedFile> {
        return projectFiles.classAndInnerClassReferences(module)
            .filter {
                it.shortName == "MyClass"
            }.map {
                generateModule(codeGenDir, it)
            }.toList()
    }

    private fun generateModule(codeGenDir: File, clas: ClassReference.Psi): GeneratedFile {
        val packageName = clas.packageFqName.safePackageString(
            dotPrefix = false,
            dotSuffix = false,
        )

        val content = FileSpec.buildFile(
            packageName = packageName,
            fileName = "MyClassModule"
        ) {
            val contributesToAnnotation = AnnotationSpec.builder(ContributesTo::class)
                .addMember("%T::class", ClassName(packageName, "AppScope"))
                .build()

            val myClassName = ClassName(packageName, "MyClass")

            val provideFunction = FunSpec.builder("provideMyClass")
                .returns(myClassName)
                .addAnnotation(Provides::class)
                .addCode("return %T()", myClassName)
                .build()

            val moduleObjectSpec = TypeSpec.Companion.objectBuilder("MyClassModule")
                .addAnnotation(Module::class)
                .addAnnotation(contributesToAnnotation)
                .addFunction(provideFunction)
                .build()

            addType(moduleObjectSpec)
        }

        return createGeneratedFile(codeGenDir, packageName, "MyClassModule", content)
    }

    override fun isApplicable(context: AnvilContext): Boolean = true
}
