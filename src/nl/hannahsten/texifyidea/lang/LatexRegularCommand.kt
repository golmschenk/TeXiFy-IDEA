package nl.hannahsten.texifyidea.lang

import nl.hannahsten.texifyidea.lang.Argument.Type
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.ALGPSEUDOCODE
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.AMSMATH
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.BIBLATEX
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.CLEVEREF
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.CSQUOTES
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.DEFAULT
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.FONTENC
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.GLOSSARIES
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.GRAPHICX
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.MATHTOOLS
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.NATBIB
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.SIUNITX
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.SUBFILES
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.ULEM
import nl.hannahsten.texifyidea.lang.LatexPackage.Companion.XCOLOR

/**
 * This class contains all LaTeX commands for which either TeXiFy has special behaviour (so it is easy to find where
 * the command is used) or for which we have to specify arguments/display/dependency in case they are not correctly
 * indexed (which is not always possible) by LatexExternalCommandIndex.
 * Some very common LaTeX commands are present in order to provide basic autocompletion functionality for users without
 * a LaTeX installation.
 *
 * @author Sten Wessel
 */
enum class LatexRegularCommand(
    override val command: String,
    override vararg val arguments: Argument = emptyArray(),
    override val dependency: LatexPackage = DEFAULT,
    override val display: String? = null,
    override val description: String = ""
) : LatexCommand {

    ADDTOCOUNTER("addtocounter", "countername".asRequired(), "value".asRequired()),
    A_RING("aa", display = "å"),
    CAPITAL_A_RING("AA", display = "Å"),
    ADDBIBRESOURCE("addbibresource", RequiredFileArgument("bibliographyfile", true, false, "bib"), dependency = BIBLATEX),
    AE("ae", display = "æ"),
    CAPITAL_AE("AE", display = "Æ"),
    APPENDIX("appendix"),
    AUTHOR("author", "name".asRequired(Type.TEXT)),
    AUTOREF("autoref", "label".asRequired(Type.TEXT), dependency = LatexPackage.HYPERREF),
    AUTOREF_CAPITAL("Autoref", "label".asRequired(Type.TEXT), dependency = LatexPackage.HYPERREF),
    BEGIN("begin", "environment".asRequired()),
    END("end", "environment".asRequired()),
    ENSUREMATH("ensuremath", "text".asRequired()),
    BASELINESKIP("baselineskip"),
    BF("bf"),
    BIBITEM("bibitem", "label".asOptional(), "citekey".asRequired()),
    BIBLIOGRAPHYSTYLE("bibliographystyle", "style".asRequired()),
    BIBLIOGRAPHY("bibliography", RequiredFileArgument("bibliographyfile", true, true, "bib")),
    BOLDMATH("boldmath"),
    CAPTION("caption", "shorttext".asOptional(), "text".asRequired(Type.TEXT)),
    CAPTIONOF("captionof", "float type".asRequired(), "list entry".asOptional(), "heading".asRequired(Type.TEXT)),
    CHAPTER("chapter", "shorttitle".asOptional(), "title".asRequired(Type.TEXT)),
    CHAPTER_STAR("chapter*", "title".asRequired(Type.TEXT)),
    CITE("cite", "extratext".asOptional(), "keys".asRequired()),
    COLORBOX2("colorbox", "model-list".asOptional(), "spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),
    COLUMNSEP("columnsep "),
    COLUMNWIDTH("columnwidth"),
    CPAGEREF("cpageref", "key".asRequired(), dependency = CLEVEREF),
    CREF("cref", "label".asRequired(), dependency = CLEVEREF),
    CREF_CAPITAL("Cref", "label".asRequired(), dependency = CLEVEREF),
    DATE("date", "text".asRequired(Type.TEXT)),
    DECLARE_MATH_OPERATOR("DeclareMathOperator", "command".asRequired(), "operator".asRequired(Type.TEXT), dependency = AMSMATH),
    DEF("def"),
    DIRECTLUA("directlua", "luacode".asRequired()),
    DOCUMENTCLASS("documentclass", "options".asOptional(), RequiredFileArgument("class", true, false, "cls")),
    EMPH("emph", "text".asRequired(Type.TEXT)),
    ENQUOTE("enquote", dependency = CSQUOTES),
    ENQUOTE_STAR("enquote*", dependency = CSQUOTES),
    EQREF("eqref", "eqLabel".asRequired(Type.TEXT), dependency = AMSMATH),
    EXTERNALDOCUMENT("externaldocument", "prefix".asOptional(), "file".asRequired()),
    FAMILY("family"),
    FLQ("flq", display = "‹"),
    FLQQ("flqq", display = "«"),
    FOOTNOTE("footnote", "number".asOptional(), "text".asRequired(Type.TEXT)),
    FRAMEBOX("framebox", "width".asOptional(), "pos".asOptional(), "text".asOptional(Type.TEXT)),
    FRQ("frq", display = "›"),
    FRQQ("frqq", display = "»"),
    FULLREF("fullref", "label".asRequired(Type.TEXT), dependency = LatexPackage.HYPERREF),
    GLOSSARYENTRY("glossaryentry", "text".asRequired(Type.TEXT), "pagenum".asRequired()),
    GLOSSARY("glossary", "text".asRequired(Type.TEXT)),
    GLQ("glq", display = ","),
    GLQQ("glqq", display = "„"),
    GRAPHICSPATH("graphicspath", RequiredFolderArgument("foldername"), dependency = GRAPHICX),
    GRQ("grq", display = "‘"),
    GRQQ("grqq", display = "“"),
    GUILLEMOTLEFT("guillemotleft", dependency = FONTENC.with("T1"), display = "«"),
    GUILLEMOTRIGHT("guillemotright", dependency = FONTENC.with("T1"), display = "»"),
    HFILL("hfill"),
    HREF("href", "url".asRequired(), "text".asRequired(), dependency = LatexPackage.HYPERREF),
    HRULE("hrule"),
    HSPACE_STAR("hspace*", "length".asRequired()),
    HSS("hss"),
    HYPERREF("hyperref", "options".asOptional(), "label".asRequired(Type.TEXT), dependency = LatexPackage.HYPERREF),
    I("i", display = "i (dotless)"),
    IMPORT("import", RequiredFolderArgument("absolute path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    INCLUDE("include", RequiredFileArgument("sourcefile", false, false, "tex")),
    INCLUDEFROM("includefrom", RequiredFolderArgument("absolute path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    INPUT("input", RequiredFileArgument("sourcefile", true, false, "tex")),
    INPUTFROM("inputfrom", RequiredFolderArgument("absolute path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    INCLUDEGRAPHICS("includegraphics", "key-val-list".asOptional(), RequiredPicturePathArgument("imagefile", true, false, "pdf", "png", "jpg", "eps", "tikz"), dependency = GRAPHICX),
    INCLUDEONLY("includeonly", RequiredFileArgument("sourcefile", false, false, "tex")),
    ITEM("item", "label".asOptional()),
    IT("it"),
    ITSHAPE("itshape"),
    LABEL("label", "key".asRequired()),
    LABELCREF("labelcref", "key".asRequired(), dependency = CLEVEREF),
    LATEX("LaTeX", display = "LaTeX"),
    LATEXE("LaTeXe", display = "LaTeX2ε"),
    LBRACK("lbrack", display = "["),
    LPAREN("lparen", display = "(", dependency = MATHTOOLS),
    LDOTS("ldots", display = "…"),
    LET("let"),
    LFSERIES("lfseries"),
    LINEBREAK("linebreak", "number".asOptional()),
    LINEWIDTH("linewidth"),
    LOADCLASS("LoadClass", "options".asOptional(), RequiredFileArgument("class", true, false, "cls")),
    LOADCLASSWITHOPTIONS("LoadClassWithOptions", RequiredFileArgument("class", true, false, "cls")),
    LOWERCASE("lowercase", "text".asRequired(Type.TEXT)),
    LQ("lq", display = "‘"),
    LUAEXEC("luaexec", "luacode".asRequired()),
    MAKENOIDXGLOSSARIES("makenoidxglossaries", dependency = GLOSSARIES),
    MAKETITLE("maketitle"),
    MARG("marg", "arg".asRequired()),
    MBOX("mbox", "text".asRequired()),
    // todo check below whether commands can be removed
    MULTICOLUMN("multicolumn", "cols".asRequired(), "pos".asRequired(), "text".asRequired(Type.TEXT)),
    NAMEREF("nameref", "label".asRequired(Type.TEXT), dependency = LatexPackage.HYPERREF),
    NEWLABEL("newlabel"),
    NEWLENGTH("newlength", "length".asRequired()),
    NEWLINE("newline"),
    NEWPAGE("newpage"),
    NEWTHEOREM("newtheorem", "envname".asRequired(), "numberedlike".asOptional(), "caption".asRequired(Type.TEXT), "within".asOptional()),
    NEWTHEOREM_STAR("newtheorem*", "envname".asRequired(), "caption".asRequired(Type.TEXT)),
    NOCITE("nocite", "keys".asRequired()),
    NOFILES("nofiles"),
    NOLINEBREAK("nolinebreak", "number".asOptional()),
    NONUMBER("nonumber"),
    NOPAGEBREAK("nopagebreak", "number".asOptional()),
    NORMALFONT("normalfont"),
    NORMALSIZE("normalsize"),
    OARG("oarg", "arg".asRequired()),
    OE("oe", display = "œ"),
    ONLYIFSTANDALONE("onlyifstandalone", "code".asRequired()), // dependency = standalone, but either class or package
    CAPITAL_OE("OE", display = "Œ"),
    ODDSIDEMARGIN("oddsidemargin"),
    ONECOLUMN("onecolumn"),
    PARG("parg", "arg".asRequired()),
    PAGEBREAK("pagebreak", "number".asOptional()),
    PAGENAME("pagename"),
    PAGENUMBERING("pagenumbering", "numstyle".asRequired()),
    PAGEREF("pageref", "label".asRequired()),
    PAGESTYLE("pagestyle", "style".asRequired()),
    PAGETOTAL("pagetotal"),
    PAPERWIDTH("paperwidth"),
    PAPERHEIGHT("paperheight"),
    PARAGRAPH("paragraph", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    PARAGRAPH_STAR("paragraph*", "title".asRequired(Type.TEXT)),
    PARAGRAPHMARK("paragraphmark"),
    PARBOX("parbox", "pos".asOptional(), "width".asRequired(), "text".asRequired(Type.TEXT)),
    PARINDENT("parindent"),
    PARSKIP("parskip"),
    PART("part", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    PART_STAR("part*", "title".asRequired(Type.TEXT)),
    PARTNAME("partname", "name".asRequired(Type.TEXT)),
    PDFINFO("pdfinfo", "info".asRequired(Type.TEXT)),
    POUNDS("pounds", display = "£"),
    PRINTBIBLIOGRAPHY("printbibliography", dependency = BIBLATEX),
    PRINTINDEX("printindex"),
    PRINTNOIDXGLOSSARIES("printnoidxglossaries", dependency = GLOSSARIES),
    PROVIDESCLASS("ProvidesClass"),
    PROVIDESPACKAGE("ProvidesPackage"),
    R("r", display = "˚ (accent)"),
    RBRACK("rbrack", display = "]"),
    RPAREN("rparen", display = ")", dependency = MATHTOOLS),
    REF("ref", "label".asRequired()),
    REFNAME("refname", "name".asRequired(Type.TEXT)),
    REQUIREPACKAGE("RequirePackage", "options".asOptional(), RequiredFileArgument("package", true, true, "sty")),
    RESETCOLORSERIES("resetcolorseries", "div".asOptional(), "name".asRequired(), dependency = XCOLOR),
    RIGHTHYPHENMIN("righthyphenmin"),
    RIGHTMARGIN("rightmargin"),
    RIGHTMARK("rightmark"),
    RM("rm"),
    RMFAMILY("rmfamily"),
    ROMAN("roman", "counter".asRequired()),
    ROTATEBOX("rotatebox", "key-val-list".asOptional(), "degrees".asRequired(), "text".asRequired(Type.TEXT), dependency = GRAPHICX),
    ROWNUM("rownum", dependency = XCOLOR),
    CAPITAL_ROMAN("Roman", "counter".asRequired()),
    RULE("rule", "line".asOptional(), "width".asRequired(), "thickness".asRequired()),
    RQ("rq", display = "’"),
    SAMEPAGE("samepage"),
    SBOX("sbox", "cmd".asRequired(), "length".asRequired()),
    SCRIPTSIZE("scriptsize"),
    SC("sc"),
    SCSHAPE("scshape"),
    SECTION("section", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SECTION_STAR("section*", "title".asRequired(Type.TEXT)),
    SELECTFONT("selectfont"),
    SETCOUNTER("setcounter", "countername".asRequired(), "value".asRequired()),
    SETLENGTH("setlength", "cmd".asRequired(), "length".asRequired()),
    SF("sf"),
    SFFAMILY("sffamily"),
    SHORTSTACK("shortstack", "pos".asOptional(), "text".asRequired(Type.TEXT)),
    SHOWROWCOLORS("showrowcolors", dependency = XCOLOR),
    SL("sl"),
    SLSHAPE("slshape"),
    SMALL("small"),
    SMALLSKIP("smallskip"),
    SMASH("smash"),
    SOUT("sout", "strikethroughtext".asRequired(Type.TEXT), dependency = ULEM),
    SPACE("space"),
    STEPCOUNTER("stepcounter", "counter".asRequired()),
    STOP("stop"),
    STRETCH("stretch", "factor".asRequired()),
    SUBFILE("subfile", RequiredFileArgument("sourcefile", true, false, "tex"), dependency = SUBFILES),
    SUBFILEINCLUDE("subfileinclude", RequiredFileArgument("sourcefile", true, false, "tex"), dependency = SUBFILES),
    SUBIMPORT("subimport", RequiredFolderArgument("relative path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    SUBINCLUDEFROM("subincludefrom", RequiredFolderArgument("relative path"), RequiredFileArgument("filename", false, false, "tex"), dependency = LatexPackage.IMPORT),
    SUBINPUTFROM("subinputfrom"),
    SUBITEM("subitem"),
    SUBPARAGRAPH("subparagraph", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SUBPARAGRAPH_STAR("subparagraph*", "title".asRequired(Type.TEXT)),
    SUBPARAGRAPHMARK("subparagraphmark", "code".asRequired()),
    SUBSECTION("subsection", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SUBSECTION_STAR("subsection*", "title".asRequired(Type.TEXT)),
    SUBSECTIONMARK("subsectionmark", "code".asRequired()),
    SUBSUBITEM("subsubitem"),
    SUBSUBSECTION("subsubsection", "shorttitle".asOptional(Type.TEXT), "title".asRequired(Type.TEXT)),
    SUBSUBSECTION_STAR("subsubsection*", "title".asRequired(Type.TEXT)),
    SUBSUBSECTIONMARK("subsubsectionmark", "code".asRequired()),
    SUPPRESSFLOATS("suppressfloats", "placement".asOptional()),
    SYMBOL("symbol", "n".asRequired()),
    TABCOLSEP("tabcolsep"),
    TABLENAME("tablename", "name".asRequired(Type.TEXT)),
    TABLEOFCONTENTS("tableofcontents"),
    TEXTASCIICIRCUM("textasciicircum", display = "^"),
    TEXTASCIITILDE("textasciitilde", display = "~"),
    TEXTASTERISKCENTERED("textasciicentered", display = "⁎"),
    TEXTBACKSLASH("textbackslash", display = "\\"),
    TEXTBAR("textbar", display = "|"),
    TEXTBF("textbf", "text".asRequired(Type.TEXT)),
    TEXTBRACELEFT("textbraceleft", display = "{"),
    TEXTBRACERIGHT("textbraceright", display = "}"),
    TEXTBULLET("textbullet", display = "•"),
    TEXTCIRCLED("textcircled", "text".asRequired()),
    TEXTCOPYRIGHT("textcopyright", display = "©"),
    TEXTDAGGER("textdagger", display = "†"),
    TEXTDAGGERDBL("textdaggerdbl", display = "‡"),
    TEXTDOLLAR("textdollar", display = "$"),
    TEXTELLIPSIS("textellipsis", display = "…"),
    TEXTEMDASH("textemdash", display = "—"),
    TEXTENDASH("textendash", display = "–"),
    TEXTEXCLAMDOWN("textexclamdown", display = "¡"),
    TEXTGREATER("textgreater", display = ">"),
    TEXTHEIGHT("textheight"),
    TEXTIT("textit", "text".asRequired(Type.TEXT)),
    TEXTLESS("textless"),
    TEXTLF("textlf", "text".asRequired(Type.TEXT)),
    TEXTMD("textmd", "text".asRequired(Type.TEXT)),
    TEXTNORMAL("textnormal"),
    TEXTPARAGRAPH("textparagraph"),
    TEXTPERIODCENTERED("textperiodcentered", display = "·"),
    TEXTQUESTIONDOWN("textquestiondown", display = "¿"),
    TEXTQUOTEDBLLEFT("textquotedblleft", display = "“"),
    TEXTQUOTEDBLRIGHT("textquotedblright", display = "”"),
    TEXTQUOTELEFT("textquoteleft", display = "‘"),
    TEXTQUOTERIGHT("textquoteright", display = "’"),
    TEXTREGISTERED("textregistered", display = "®"),
    TEXTRM("textrm", "text".asRequired(Type.TEXT)),
    TEXTSC("textsc", "textsc".asRequired(Type.TEXT)),
    TEXTSECTION("textsection", display = "§"),
    TEXTSF("textsf", "text".asRequired(Type.TEXT)),
    TEXTSL("textsl", "text".asRequired(Type.TEXT)),
    TEXTSTERLING("textsterling", display = "£"),
    TEXTSUBSCRIPT("textsubscript", "text".asRequired(Type.TEXT)),
    TEXTSUPERSCRIPT("textsuperscript", "text".asRequired(Type.TEXT)),
    TEXTTRADEMARK("texttrademark", display = "™"),
    TEXTTT("texttt", "text".asRequired(Type.TEXT)),
    TEXTUNDERSCORE("textunderscore", display = "_"),
    TEXTUP("textup", "text".asRequired(Type.TEXT)),
    TEXTVISIBLESPACE("textvisiblespace", display = "␣"),
    TEXTWIDTH("textwidth"),
    THANKS("thanks", "to".asRequired(Type.TEXT)),
    THICKLINES("thicklines"),
    THINLINES("thinlines"),
    THISPAGESTYLE("thispagestyle", "style".asRequired()),
    TIME("time"),
    TINY("tiny"),
    TITLE("title", "text".asRequired(Type.TEXT)),
    TODAY("today"),
    TOPMARGIN("topmargin"),
    TT("tt"),
    TTFAMILY("ttfamily"),
    TWOCOLUMN("twocolumn", "text".asOptional(Type.TEXT)),
    UNBOLDMATH("unboldmath"),
    UNDERLINE("underline", "text".asRequired(Type.TEXT)),
    UNITLENGTH("unitlength"),
    UPPERCASE("uppercase", "text".asRequired(Type.TEXT)),
    UPSHAPE("upshape"),
    URL("url", "url".asRequired(), dependency = LatexPackage.HYPERREF),
    USEPACKAGE("usepackage", "options".asOptional(), RequiredFileArgument("package", true, true, "sty")),
    VDOTS("vdots", display = "⋮"),
    VLINE("vline"),
    VREF("vref", "key".asRequired(), dependency = CLEVEREF),
    VSPACE("vspace", "length".asRequired()),
    VSPACE_STAR("vspace*", "length".asRequired()),
    WIDTH("width"),
    XGLOBAL("xglobal", dependency = XCOLOR),

    /**
     * Commands with a color argument, used to display gutter icons. See [nl.hannahsten.texifyidea.util.Magic#Color.takeColorCommands].
     */
    COLOR("color", "color".asRequired(), dependency = LatexPackage.COLOR),
    COLOR2("color", "model-list".asOptional(), "spec-list".asRequired(), dependency = XCOLOR),
    COLORBOX("colorbox", "color".asRequired(), "text".asRequired(), dependency = XCOLOR),
    EXTRACTCOLORSPEC("extractcolorspec", "color".asRequired(), "cmd".asRequired(), dependency = XCOLOR),
    EXTRACTCOLORSPECS("extractcolorspecs", "color".asRequired(), "model-cmd".asRequired(), "color-cmd".asRequired(), dependency = XCOLOR),
    FCOLORBOX("fcolorbox", "frame color".asRequired(), "background color".asRequired(), "text".asRequired(), dependency = XCOLOR),
    FCOLORBOX4("fcolorbox", "frame color".asRequired(), "background model-list".asOptional(), "background spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),
    MASKCOLORS("maskcolors", "num model".asOptional(), "color".asRequired(), dependency = XCOLOR),
    NOPAGECOLOR("nopagecolor", dependency = XCOLOR),
    NORMALCOLOR("normalcolor"),
    PAGECOLOR("pagecolor", "color".asRequired(), dependency = XCOLOR),
    PAGECOLOR2("pagecolor", "model-list".asOptional(), "spec-list".asRequired(), dependency = XCOLOR),
    ROWCOLORS("rowcolors", "commands".asOptional(), "row".asRequired(), "odd-row color".asRequired(), "even-row color".asRequired(), dependency = XCOLOR),
    ROWCOLORS_STAR("rowcolors*", "commands".asOptional(), "row".asRequired(), "odd-row color".asRequired(), "even-row color".asRequired(), dependency = XCOLOR),
    TESTCOLOR("testcolor", "color".asRequired(), dependency = XCOLOR),
    TESTCOLOR2("testcolor", "model-list".asOptional(), "spec-list".asRequired(), dependency = XCOLOR),
    TEXTCOLOR("textcolor", "color".asRequired(), "text".asRequired(), dependency = XCOLOR),
    TEXTCOLOR2("textcolor", "model-list".asOptional(), "spec-list".asRequired(), "text".asRequired(), dependency = XCOLOR),

    /**
     * New definitions
     */
    NEWCOMMAND("newcommand", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    NEWCOMMAND_STAR("newcommand*", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    NEWIF("newif", "cmd".asRequired()),
    PROVIDECOMMAND("providecommand", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    PROVIDECOMMAND_STAR("providecommand*", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    RENEWCOMMAND("renewcommand", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    RENEWCOMMAND_STAR("renewcommand*", "cmd".asRequired(), "args".asOptional(), "default".asOptional(), "def".asRequired(Type.TEXT)),
    NEWENVIRONMENT("newenvironment", "name".asRequired(), "args".asOptional(), "default".asOptional(), "begdef".asRequired(Type.TEXT), "enddef".asRequired(Type.TEXT)),
    RENEWENVIRONMENT("renewenvironment", "name".asRequired(), "args".asOptional(), "default".asOptional(), "begdef".asRequired(Type.TEXT), "enddef".asRequired(Type.TEXT)),

    /**
     * mathtools definitions
     */
    DECLARE_PAIRED_DELIMITER("DeclarePairedDelimiter", "cmd".asRequired(), "left delimiter".asRequired(), "right delimiter".asRequired(), dependency = MATHTOOLS),
    DECLARE_PAIRED_DELIMITER_X("DeclarePairedDelimiterX", "cmd".asRequired(), "num args".asOptional(), "left delimiter".asRequired(), "right delimiter".asRequired(), "body".asRequired(Type.TEXT), dependency = MATHTOOLS),
    DECLARE_PAIRED_DELIMITER_XPP("DeclarePairedDelimiterXPP", "cmd".asRequired(), "num args".asOptional(), "pre code".asRequired(), "left delimiter".asRequired(), "right delimiter".asRequired(), "post code".asRequired(), "body".asRequired(Type.TEXT), dependency = MATHTOOLS),

    /**
     * xcolor definitions
     */
    DEFINECOLOR("definecolor", "type".asOptional(), "name".asRequired(), "model-list".asRequired(), "spec-list".asRequired(), dependency = XCOLOR),
    PROVIDECOLOR("providecolor", "type".asOptional(), "name".asRequired(), "model-list".asRequired(), "spec-list".asRequired(), dependency = XCOLOR),
    COLORLET("colorlet", "type".asOptional(), "name".asRequired(), "num model".asOptional(), "color".asRequired(), dependency = XCOLOR),
    DEFINECOLORSET("definecolorset", "type".asOptional(), "model-list".asRequired(), "head".asRequired(), "tail".asRequired(), "set spec".asRequired(), dependency = XCOLOR),
    PROVIDECOLORSET("providecolorset", "type".asOptional(), "model-list".asRequired(), "head".asRequired(), "tail".asRequired(), "set spec".asRequired(), dependency = XCOLOR),
    PREPARECOLOR("preparecolor", "type".asOptional(), "name".asRequired(), "model-list".asRequired(), "spec-list".asRequired(), dependency = XCOLOR),
    PREPARECOLORSET("preparecolorset", "type".asOptional(), "model-list".asRequired(), "head".asRequired(), "tail".asRequired(), "set spec".asRequired(), dependency = XCOLOR),
    DEFINE_NAMED_COLOR("DefineNamedColor", "type".asRequired(), "name".asRequired(), "model-list".asRequired(), "spec-list".asRequired(), dependency = XCOLOR),
    DEFINECOLORS("definecolors", "id-list".asRequired(), dependency = XCOLOR),
    PROVIDECOLORS("providecolors", "id-list".asRequired(), dependency = XCOLOR),
    DEFINECOLORSERIES("definecolorseries", "name".asRequired(), "core model".asRequired(), "method".asRequired(), "b-model".asOptional(), "b-spec".asRequired(), "s-model".asRequired(), "s-spec".asRequired(), dependency = XCOLOR),

    /**
     * Xparse definitions
     */
    NEWDOCUMENTCOMMAND("NewDocumentCommand", "name".asRequired(), "args spec".asRequired(), "code".asRequired(), dependency = LatexPackage.XPARSE),
    RENEWDOCUMENTCOMMAND("RenewDocumentCommand", "name".asRequired(), "args spec".asRequired(), "code".asRequired(), dependency = LatexPackage.XPARSE),
    PROVIDEDOCUMENTCOMMAND("ProvideDocumentCommand", "name".asRequired(), "args spec".asRequired(), "code".asRequired(), dependency = LatexPackage.XPARSE),
    DECLAREDOCUMENTCOMMAND("DeclareDocumentCommand", "name".asRequired(), "args spec".asRequired(), "code".asRequired(), dependency = LatexPackage.XPARSE),
    NEWDOCUMENTENVIRONMENT("NewDocumentEnvironment", "name".asRequired(), "args spec".asRequired(), "start code".asRequired(), "end code".asRequired(), dependency = LatexPackage.XPARSE),
    RENEWDOCUMENTENVIRONMENT("RenewDocumentEnvironment", "name".asRequired(), "args spec".asRequired(), "start code".asRequired(), "end code".asRequired(), dependency = LatexPackage.XPARSE),
    PROVIDEDOCUMENTENVIRONMENT("ProvideDocumentEnvironment", "name".asRequired(), "args spec".asRequired(), "start code".asRequired(), "end code".asRequired(), dependency = LatexPackage.XPARSE),
    DECLAREDOCUMENTENVIRONMENT("DeclareDocumentEnvironment", "name".asRequired(), "args spec".asRequired(), "start code".asRequired(), "end code".asRequired(), dependency = LatexPackage.XPARSE),

    /**
     * Natbib citations
     */
    CITEP("citep", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEP_STAR("citep*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITET("citet", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITET_STAR("citet*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEP_CAPITALIZED("Citep", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEP_STAR_CAPITALIZED("Citep*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITET_CAPITALIZED("Citet", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITET_STAR_CAPITALIZED("Citet*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALP("citealp", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALP_STAR("citealp*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALT("citealt", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALT_STAR("citealt*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALP_CAPITALIZED("Citealp", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALP_STAR_CAPITALIZED("Citealp*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALT_CAPITALIZED("Citealt", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEALT_STAR_CAPITALIZED("Citealt*", "before".asOptional(), "after".asOptional(), "keys".asRequired(), dependency = NATBIB),
    CITEAUTHOR("citeauthor", "keys".asRequired(), dependency = NATBIB),
    CITEAUTHOR_STAR("citeauthor*", "keys".asRequired(), dependency = NATBIB),
    CITEAUTHOR_CAPITALIZED("Citeauthor", "keys".asRequired(), dependency = NATBIB),
    CITEAUTHOR_STAR_CAPITALIZED("Citeauthor*", "keys".asRequired(), dependency = NATBIB),
    CITEYEAR("citeyear", "keys".asRequired(), dependency = NATBIB),
    CITEYEARPAR("citeyearpar", "keys".asRequired(), dependency = NATBIB),
    CITENUM("citenum", "key".asRequired(), dependency = NATBIB),
    CITETEXT("citetext", "text".asRequired(), dependency = NATBIB),

    /**
     * Biblatex commands
     */
    CITE_CAPITALIZED("Cite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PARENCITE("parencite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PARENCITE_CAPITALIZED("Parencite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FOOTCITE("footcite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FOOTCITETEXT("footcitetext", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    TEXTCITE("textcite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    TEXTCITE_CAPITALIZED("Textcite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    SMARTCITE("smartcite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    SMARTCITE_CAPITALIZED("Smartcite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    CITE_STAR("cite*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PARENCITE_STAR("parencite*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    SUPERCITE("supercite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    AUTOCITE("autocite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    AUTOCITE_CAPITALIZED("Autocite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    AUTOCITE_STAR("autocite*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    AUTOCITE_STAR_CAPITALIZED("Autocite*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITEAUTHOR("citeauthor", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITEAUTHOR_STAR("citeauthor*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITEAUTHOR_CAPITALIZED("Citeauthor", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITEAUTHOR_STAR_CAPITALIZED("Citeauthor*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITETITLE("citetitle", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITETITLE_STAR("citetitle*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITEYEAR("citeyear", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_CITEYEAR_STAR("citeyear*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    CITEDATE("citedate", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    CITEDATE_STAR("citedate*", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    CITEURL("citeurl", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    VOLCITE("volcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    VOLCITE_CAPITALIZED("Volcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PVOLCITE("pvolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PVOLCITE_CAPITALIZED("Pvolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FVOLCITE("fvolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FVOLCITE_CAPITALIZED("Fvolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FTVOLCITE("ftvolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    SVOLCITE("svolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    SVOLCITE_CAPITALIZED("Svolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    TVOLCITE("tvolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    TVOLCITE_CAPITALIZED("Tvolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    AVOLCITE("avolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    AVOLCITE_CAPITALIZED("Avolcite", "prenote".asOptional(), "volume".asRequired(), "page".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FULLCITE("fullcite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FOOTFULLCITE("footcullcite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    BIBLATEX_NOCITE("nocite", "key".asRequired(), dependency = BIBLATEX),
    NOTECITE("notecite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    NOTECITE_CAPITALIZED("Notecite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PNOTECITE("pnotecite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PNOTECITE_CAPITALIZED("Pnotecite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    FNOTECITE("fnotecite", "prenote".asOptional(), "postnote".asOptional(), "key".asRequired(), dependency = BIBLATEX),
    PARENTTEXT("parenttext", "text".asRequired(Type.TEXT), dependency = BIBLATEX),
    BRACKETTEXT("brackettext", "text".asRequired(Type.TEXT), dependency = BIBLATEX),

    /**
     * SIunitx commands
     */
    ANG("ang", "options".asOptional(), "angle".asRequired(), dependency = SIUNITX),
    NUM("num", "options".asOptional(), "number".asRequired(), dependency = SIUNITX),
    SI("si", "options".asOptional(), "unit".asRequired(), dependency = SIUNITX),
    SI_NUM("SI", "options".asOptional(), "number".asRequired(), "pre-unit".asOptional(), "unit".asRequired(), dependency = SIUNITX),
    NUMLIST("numlist", "options".asOptional(), "numbers".asRequired(), dependency = SIUNITX),
    NUMRANGE("numrange", "options".asOptional(), "number1".asRequired(), "number2".asRequired(), dependency = SIUNITX),
    SILIST("SIlist", "options".asOptional(), "numbers".asRequired(), "unit".asRequired(), dependency = SIUNITX),
    SIRANGE("numrange", "options".asOptional(), "number1".asRequired(), "number2".asRequired(), "unit".asRequired(), dependency = SIUNITX),
    SISETUP("sisetup", "options".asRequired(), dependency = SIUNITX),
    TABLENUM("tablenum", "options".asOptional(), "number".asRequired(), dependency = SIUNITX),

    /**
     * Algorithmicx
     */
    FOR("For", "condition".asRequired(), dependency = ALGPSEUDOCODE),
    FORALL("ForAll", "condition".asRequired(), dependency = ALGPSEUDOCODE),
    ENDFOR("EndFor", dependency = ALGPSEUDOCODE),
    IF_ALGPSEUDOCODE("If", "condition".asRequired(), dependency = ALGPSEUDOCODE),
    ELSIF("ElsIf", "condition".asRequired(), dependency = ALGPSEUDOCODE),
    ENDIF("EndIf", dependency = ALGPSEUDOCODE),
    WHILE("While", "condition".asRequired(), dependency = ALGPSEUDOCODE),
    ENDWHILE("EndWhile", dependency = ALGPSEUDOCODE),
    REPEAT("Repeat", dependency = ALGPSEUDOCODE),
    UNTIL("Until", "condition".asRequired(), dependency = ALGPSEUDOCODE),
    LOOP("Loop", dependency = ALGPSEUDOCODE),
    ENDLOOP("EndLoop", dependency = ALGPSEUDOCODE),
    FUNCTION("Function", "name".asRequired(), "params".asRequired(), dependency = ALGPSEUDOCODE),
    ENDFUNCTION("EndFunction", dependency = ALGPSEUDOCODE),
    PROCEDURE("Procedure", "name".asRequired(), "params".asRequired(), dependency = ALGPSEUDOCODE),
    ENDPROCEDURE("EndProcedure", dependency = ALGPSEUDOCODE),

    /*
     * If- commands
     * Source: http://mirrors.ctan.org/info/texbytopic/TeXbyTopic.pdf chapter Conditionals
     */
    IF("if"),
    IFCAT("ifcat"),
    IFX("ifx"),
    IFCASE("ifcase"),
    IFNUM("ifnum"),
    IFODD("ifodd"),
    IFHMODE("ifhmode"),
    IFVMODE("ifvmode"),
    IFMMODE("ifmmode"),
    IFINNER("ifinner"),
    IFDIM("ifdim"),
    IFVOID("ifvoid"),
    IFHBOX("ifhbox"),
    IFVBOX("ifvbox"),
    IFEOF("ifeof"),
    IFTRUE("iftrue"),
    IFFALSE("iffalse"),
    FI("fi"),
    ELSE("else"),
    OR("or");

    companion object {

        private val lookup = HashMap<String, MutableSet<LatexRegularCommand>>()
        private val lookupDisplay = HashMap<String, MutableSet<LatexRegularCommand>>()

        init {
            @Suppress("RemoveRedundantQualifierName")
            for (command in LatexRegularCommand.values()) {
                lookup.getOrPut(command.command) { mutableSetOf() }.add(command)
                if (command.display != null) {
                    lookupDisplay.putIfAbsent(command.display!!, mutableSetOf(command))?.add(command)
                }
            }
        }

        @JvmStatic
        operator fun get(command: String) = lookup[command]?.toSet()

        @JvmStatic
        fun findByDisplay(display: String) = lookupDisplay[display]?.toSet()
    }
}
