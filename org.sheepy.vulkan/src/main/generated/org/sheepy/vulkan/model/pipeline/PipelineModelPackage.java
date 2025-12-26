package org.sheepy.vulkan.model.pipeline;

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

public final class PipelineModelPackage implements IModelPackage {
  public static final PipelineModelPackage Instance = new PipelineModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Pipeline").domain("org.sheepy.vulkan.model").addImports(List.of("org.sheepy.vulkan.model.Enumeration")).genNamePackage(true).lmPackage(Instance).addGroups(PipelineModelDefinition.Groups.ALL).addEnums(PipelineModelDefinition.Enums.ALL).addUnits(PipelineModelDefinition.Units.ALL).addAliases(PipelineModelDefinition.Aliases.ALL).addJavaWrappers(PipelineModelDefinition.JavaWrappers.ALL).build();

  private PipelineModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == PipelineModelDefinition.Groups.PUSH_CONSTANT_RANGE) return Optional.of((IFeaturedObject.Builder<T>) PushConstantRange.builder());
    else if (group == PipelineModelDefinition.Groups.SPECIALIZATION_CONSTANT) return Optional.of((IFeaturedObject.Builder<T>) SpecializationConstant.builder());
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
