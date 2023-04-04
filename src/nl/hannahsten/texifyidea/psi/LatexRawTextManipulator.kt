package nl.hannahsten.texifyidea.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import nl.hannahsten.texifyidea.grammar.LatexLanguage
import nl.hannahsten.texifyidea.psi.impl.LatexEnvironmentImpl
import nl.hannahsten.texifyidea.psi.impl.LatexRawTextImpl

/**
 * Enable editing raw text content in a separate window (when using language injection).
 */
class LatexRawTextManipulator : AbstractElementManipulator<LatexRawTextImpl>() {

    override fun handleContentChange(
            element: LatexRawTextImpl,
            range: TextRange,
            newContent: String
    ): LatexRawTextImpl? {
        val file = PsiFileFactory.getInstance(element.project)
                .createFileFromText("temp.tex", LatexLanguage, newContent)
        val res = PsiTreeUtil.findChildOfType(file, LatexEnvironmentImpl::class.java) ?: return null
        element.replace(res)
        return element
    }
}
