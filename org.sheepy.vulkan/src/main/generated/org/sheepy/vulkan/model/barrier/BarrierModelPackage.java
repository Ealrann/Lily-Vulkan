package org.sheepy.vulkan.model.barrier;

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

public final class BarrierModelPackage implements IModelPackage {
  public static final BarrierModelPackage Instance = new BarrierModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Barrier").domain("org.sheepy.vulkan.model").addImports(List.of("org.sheepy.lily.core.model.Types", "org.sheepy.vulkan.model.Enumeration")).genNamePackage(true).lmPackage(Instance).addGroups(BarrierModelDefinition.Groups.ALL).addEnums(BarrierModelDefinition.Enums.ALL).addUnits(BarrierModelDefinition.Units.ALL).addAliases(BarrierModelDefinition.Aliases.ALL).addJavaWrappers(BarrierModelDefinition.JavaWrappers.ALL).build();

  private BarrierModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == BarrierModelDefinition.Groups.IMAGE_TRANSITION) return Optional.of((IFeaturedObject.Builder<T>) ImageTransition.builder());
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
