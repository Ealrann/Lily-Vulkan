package org.sheepy.lily.openal.model.openal;

import java.util.List;
import java.util.Optional;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IJavaWrapperConverter;
import org.logoce.lmf.core.api.model.IModelPackage;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.MetaModel;
import org.logoce.lmf.core.lang.builder.MetaModelBuilder;

public final class OpenALModelPackage implements IModelPackage {
  public static final OpenALModelPackage Instance = new OpenALModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("OpenAL").domain("org.sheepy.lily.openal.model").addImports(List.of("org.sheepy.lily.core.model.Application", "org.sheepy.lily.core.model.Resource")).genNamePackage(true).lmPackage(Instance).addGroups(OpenALModelDefinition.Groups.ALL).addEnums(OpenALModelDefinition.Enums.ALL).addUnits(OpenALModelDefinition.Units.ALL).addAliases(OpenALModelDefinition.Aliases.ALL).addJavaWrappers(OpenALModelDefinition.JavaWrappers.ALL).build();

  private OpenALModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == OpenALModelDefinition.Groups.OPENAL_ENGINE) return Optional.of((IFeaturedObject.Builder<T>) OpenALEngine.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
