// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import org.elixir_lang.psi.stub.UnmatchedUnqualifiedParenthesesCall;
import com.intellij.psi.StubBasedPsiElement;
import com.ericsson.otp.erlang.OtpErlangObject;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import java.util.Set;

public interface ElixirUnmatchedUnqualifiedParenthesesCall extends ElixirUnmatchedExpression, UnqualifiedParenthesesCall<UnmatchedUnqualifiedParenthesesCall>, StubBasedPsiElement<UnmatchedUnqualifiedParenthesesCall> {

  @Nullable
  ElixirDoBlock getDoBlock();

  @NotNull
  ElixirIdentifier getIdentifier();

  @NotNull
  ElixirMatchedParenthesesArguments getMatchedParenthesesArguments();

  @Nullable String canonicalName();

  @NotNull Set<String> canonicalNameSet();

  @Nullable String functionName();

  @NotNull PsiElement functionNameElement();

  //WARNING: getDoBlock(...) is skipped
  //matching getDoBlock(ElixirUnmatchedUnqualifiedParenthesesCall, ...)
  //methods are not found in ElixirPsiImplUtil

  boolean hasDoBlockOrKeyword();

  @Nullable String getName();

  @Nullable PsiElement getNameIdentifier();

  @NotNull ItemPresentation getPresentation();

  @Nullable PsiReference getReference();

  //WARNING: getStub(...) is skipped
  //matching getStub(ElixirUnmatchedUnqualifiedParenthesesCall, ...)
  //methods are not found in ElixirPsiImplUtil

  //WARNING: getUseScope(...) is skipped
  //matching getUseScope(ElixirUnmatchedUnqualifiedParenthesesCall, ...)
  //methods are not found in ElixirPsiImplUtil

  boolean isCalling(@NotNull String resolvedModuleName, @NotNull String functionName);

  boolean isCalling(@NotNull String resolvedModuleName, @NotNull String functionName, int resolvedFinalArity);

  boolean isCallingMacro(@NotNull String resolvedModuleName, @NotNull String functionName);

  boolean isCallingMacro(@NotNull String resolvedModuleName, @NotNull String functionName, int resolvedFinalArity);

  @Nullable String implementedProtocolName();

  @Nullable String moduleName();

  @NotNull PsiElement[] primaryArguments();

  @Nullable Integer primaryArity();

  boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place);

  @NotNull OtpErlangObject quote();

  int resolvedFinalArity();

  @NotNull ArityInterval resolvedFinalArityInterval();

  @NotNull String resolvedModuleName();

  @Nullable Integer resolvedPrimaryArity();

  @Nullable Integer resolvedSecondaryArity();

  @Nullable PsiElement[] secondaryArguments();

  @Nullable Integer secondaryArity();

  @NotNull PsiElement setName(@NotNull String newName);

}
