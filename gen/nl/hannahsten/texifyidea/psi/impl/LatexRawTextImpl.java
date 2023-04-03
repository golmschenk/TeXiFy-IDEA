// This is a generated file. Not intended for manual editing.
package nl.hannahsten.texifyidea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.hannahsten.texifyidea.psi.LatexTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import nl.hannahsten.texifyidea.psi.*;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiLanguageInjectionHost;

public class LatexRawTextImpl extends ASTWrapperPsiElement implements LatexRawText {

  public LatexRawTextImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LatexVisitor visitor) {
    visitor.visitRawText(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LatexVisitor) accept((LatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public boolean isValidHost() {
    return LatexPsiImplUtil.isValidHost(this);
  }

  @Override
  public PsiLanguageInjectionHost updateText(@NotNull String text) {
    return LatexPsiImplUtil.updateText(this, text);
  }

  @Override
  public @NotNull LiteralTextEscaper<LatexRawText> createLiteralTextEscaper() {
    return LatexPsiImplUtil.createLiteralTextEscaper(this);
  }

}
