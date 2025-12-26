package org.sheepy.lily.vulkan.extra.model.mesh;

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

public final class MeshModelPackage implements IModelPackage {
  public static final MeshModelPackage Instance = new MeshModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Mesh").domain("org.sheepy.lily.vulkan.extra.model").addImports(List.of("org.sheepy.lily.vulkan.extra.model.Rendering")).genNamePackage(true).lmPackage(Instance).addGroups(MeshModelDefinition.Groups.ALL).addEnums(MeshModelDefinition.Enums.ALL).addUnits(MeshModelDefinition.Units.ALL).addAliases(MeshModelDefinition.Aliases.ALL).addJavaWrappers(MeshModelDefinition.JavaWrappers.ALL).build();

  private MeshModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == MeshModelDefinition.Groups.MESH_RENDERER) return Optional.of((IFeaturedObject.Builder<T>) MeshRenderer.builder());
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
