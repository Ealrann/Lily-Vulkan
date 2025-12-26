package org.sheepy.lily.vulkan.extra.model.rendering;

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

public final class RenderingModelPackage implements IModelPackage {
  public static final RenderingModelPackage Instance = new RenderingModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Rendering").domain("org.sheepy.lily.vulkan.extra.model").addImports(List.of("org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Resource", "org.sheepy.lily.core.model.Variable", "org.sheepy.lily.core.model.Maintainer", "org.sheepy.lily.vulkan.model.process.Graphic", "org.sheepy.lily.vulkan.model.Process", "org.sheepy.lily.vulkan.model.Vulkan", "org.sheepy.lily.vulkan.model.VulkanResource", "org.sheepy.vulkan.model.Enumeration")).genNamePackage(true).lmPackage(Instance).addGroups(RenderingModelDefinition.Groups.ALL).addEnums(RenderingModelDefinition.Enums.ALL).addUnits(RenderingModelDefinition.Units.ALL).addAliases(RenderingModelDefinition.Aliases.ALL).addJavaWrappers(RenderingModelDefinition.JavaWrappers.ALL).build();

  private RenderingModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == RenderingModelDefinition.Groups.AXIS) return Optional.of((IFeaturedObject.Builder<T>) Axis.builder());
    else if (group == RenderingModelDefinition.Groups.STRUCTURE_PKG) return Optional.of((IFeaturedObject.Builder<T>) StructurePkg.builder());
    else if (group == RenderingModelDefinition.Groups.STRUCTURES) return Optional.of((IFeaturedObject.Builder<T>) Structures.builder());
    else if (group == RenderingModelDefinition.Groups.PRESENTABLE_ENTITY) return Optional.of((IFeaturedObject.Builder<T>) PresentableEntity.builder());
    else if (group == RenderingModelDefinition.Groups.DATA_PROVIDER_PKG) return Optional.of((IFeaturedObject.Builder<T>) DataProviderPkg.builder());
    else if (group == RenderingModelDefinition.Groups.DATA_PROVIDER) return Optional.of((IFeaturedObject.Builder<T>) DataProvider.builder());
    else if (group == RenderingModelDefinition.Groups.INDEXED_DATA_DESCRIPTION) return Optional.of((IFeaturedObject.Builder<T>) IndexedDataDescription.builder());
    else if (group == RenderingModelDefinition.Groups.RENDERABLE_DATA_SOURCE) return Optional.of((IFeaturedObject.Builder<T>) RenderableDataSource.builder());
    else if (group == RenderingModelDefinition.Groups.DESCRIPTORS_PROVIDER) return Optional.of((IFeaturedObject.Builder<T>) DescriptorsProvider.builder());
    else if (group == RenderingModelDefinition.Groups.DATA_DESCRIPTORS_PROVIDER) return Optional.of((IFeaturedObject.Builder<T>) DataDescriptorsProvider.builder());
    else if (group == RenderingModelDefinition.Groups.DATA_DESCRIPTOR) return Optional.of((IFeaturedObject.Builder<T>) DataDescriptor.builder());
    else if (group == RenderingModelDefinition.Groups.RESOURCE_DESCRIPTOR_PROVIDER_PKG) return Optional.of((IFeaturedObject.Builder<T>) ResourceDescriptorProviderPkg.builder());
    else if (group == RenderingModelDefinition.Groups.RENDER_PROXY_CONSTANT_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) RenderProxyConstantBuffer.builder());
    else if (group == RenderingModelDefinition.Groups.PHYSICAL_ENTITY_VARIABLE) return Optional.of((IFeaturedObject.Builder<T>) PhysicalEntityVariable.builder());
    else if (group == RenderingModelDefinition.Groups.CAMERA) return Optional.of((IFeaturedObject.Builder<T>) Camera.builder());
    else if (group == RenderingModelDefinition.Groups.CAMERA_MATRIX) return Optional.of((IFeaturedObject.Builder<T>) CameraMatrix.builder());
    else if (group == RenderingModelDefinition.Groups.CAMERA_POSITION) return Optional.of((IFeaturedObject.Builder<T>) CameraPosition.builder());
    else if (group == RenderingModelDefinition.Groups.CAMERA_SCREEN_WORLD_POSITION) return Optional.of((IFeaturedObject.Builder<T>) CameraScreenWorldPosition.builder());
    else if (group == RenderingModelDefinition.Groups.CAMERA_VARIABLE) return Optional.of((IFeaturedObject.Builder<T>) CameraVariable.builder());
    else if (group == RenderingModelDefinition.Groups.MOUSE_PICK_CONSTANTS) return Optional.of((IFeaturedObject.Builder<T>) MousePickConstants.builder());
    else if (group == RenderingModelDefinition.Groups.MOUSE_PICK_EXTENSION) return Optional.of((IFeaturedObject.Builder<T>) MousePickExtension.builder());
    else if (group == RenderingModelDefinition.Groups.ENTITY_RESOLVER_PIPELINE) return Optional.of((IFeaturedObject.Builder<T>) EntityResolverPipeline.builder());
    else if (group == RenderingModelDefinition.Groups.SELECTION_PROXY) return Optional.of((IFeaturedObject.Builder<T>) SelectionProxy.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    if (enum_ == RenderingModelDefinition.Enums.E_PHYSICAL_ENTITY_FEATURE) return (Optional<T>) Optional.of(EPhysicalEntityFeature.valueOf(value));
    else if (enum_ == RenderingModelDefinition.Enums.E_CAMERA_FIELD) return (Optional<T>) Optional.of(ECameraField.valueOf(value));
    else if (enum_ == RenderingModelDefinition.Enums.E_MOUSE_PICK_MODE) return (Optional<T>) Optional.of(EMousePickMode.valueOf(value));
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
