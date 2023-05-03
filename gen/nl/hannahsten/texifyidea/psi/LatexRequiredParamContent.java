// This is a generated file. Not intended for manual editing.
package nl.hannahsten.texifyidea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.LiteralTextEscaper;

public interface LatexRequiredParamContent extends PsiLanguageInjectionHost {

  @Nullable
  LatexComment getComment();

  @Nullable
  LatexEnvironment getEnvironment();

  @Nullable
  LatexGroup getGroup();

  @Nullable
  LatexMagicComment getMagicComment();

  @Nullable
  LatexMathEnvironment getMathEnvironment();

  @Nullable
  LatexParameterText getParameterText();

  @Nullable
  LatexPseudocodeBlock getPseudocodeBlock();

  @Nullable
  LatexRawText getRawText();

  boolean isValidHost();

  PsiLanguageInjectionHost updateText(@NotNull String text);

  @NotNull LiteralTextEscaper<LatexRequiredParamContent> createLiteralTextEscaper();

}
