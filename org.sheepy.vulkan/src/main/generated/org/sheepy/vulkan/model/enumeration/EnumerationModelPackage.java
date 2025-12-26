package org.sheepy.vulkan.model.enumeration;

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

public final class EnumerationModelPackage implements IModelPackage {
  public static final EnumerationModelPackage Instance = new EnumerationModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Enumeration").domain("org.sheepy.vulkan.model").genNamePackage(true).lmPackage(Instance).addGroups(EnumerationModelDefinition.Groups.ALL).addEnums(EnumerationModelDefinition.Enums.ALL).addUnits(EnumerationModelDefinition.Units.ALL).addAliases(EnumerationModelDefinition.Aliases.ALL).addJavaWrappers(EnumerationModelDefinition.JavaWrappers.ALL).build();

  private EnumerationModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    if (enum_ == EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT) return (Optional<T>) Optional.of(EImageLayout.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_PHYSICAL_DEVICE_FEATURE) return (Optional<T>) Optional.of(EPhysicalDeviceFeature.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_CULL_MODE) return (Optional<T>) Optional.of(ECullMode.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_DESCRIPTOR_TYPE) return (Optional<T>) Optional.of(EDescriptorType.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_FRONT_FACE) return (Optional<T>) Optional.of(EFrontFace.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_BORDER_COLOR) return (Optional<T>) Optional.of(EBorderColor.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_COMMAND_STAGE) return (Optional<T>) Optional.of(ECommandStage.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_ATTACHMENT_LOAD_OP) return (Optional<T>) Optional.of(EAttachmentLoadOp.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_LOGIC_OP) return (Optional<T>) Optional.of(ELogicOp.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_PRIMITIVE_TOPOLOGY) return (Optional<T>) Optional.of(EPrimitiveTopology.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_ATTACHMENT_STORE_OP) return (Optional<T>) Optional.of(EAttachmentStoreOp.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_SHADER_STAGE) return (Optional<T>) Optional.of(EShaderStage.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_FILTER) return (Optional<T>) Optional.of(EFilter.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_SAMPLER_MIPMAP_MODE) return (Optional<T>) Optional.of(ESamplerMipmapMode.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_SAMPLER_ADDRESS_MODE) return (Optional<T>) Optional.of(ESamplerAddressMode.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_BLEND_FACTOR) return (Optional<T>) Optional.of(EBlendFactor.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_INDEX_TYPE) return (Optional<T>) Optional.of(EIndexType.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_INPUT_RATE) return (Optional<T>) Optional.of(EInputRate.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_DYNAMIC_STATE) return (Optional<T>) Optional.of(EDynamicState.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_BLEND_OP) return (Optional<T>) Optional.of(EBlendOp.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_ACCESS) return (Optional<T>) Optional.of(EAccess.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_PIPELINE_STAGE) return (Optional<T>) Optional.of(EPipelineStage.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_COLOR_SPACE) return (Optional<T>) Optional.of(EColorSpace.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_FORMAT) return (Optional<T>) Optional.of(EFormat.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_PRESENT_MODE) return (Optional<T>) Optional.of(EPresentMode.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_POLYGON_MODE) return (Optional<T>) Optional.of(EPolygonMode.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_IMAGE_USAGE) return (Optional<T>) Optional.of(EImageUsage.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_BUFFER_USAGE) return (Optional<T>) Optional.of(EBufferUsage.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_MEMORY_PROPERTY) return (Optional<T>) Optional.of(EMemoryProperty.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_SAMPLE_COUNT) return (Optional<T>) Optional.of(ESampleCount.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_BIND_POINT) return (Optional<T>) Optional.of(EBindPoint.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_INSTANCE_COUNT) return (Optional<T>) Optional.of(EInstanceCount.valueOf(value));
    else if (enum_ == EnumerationModelDefinition.Enums.E_COMPARE_OP) return (Optional<T>) Optional.of(ECompareOp.valueOf(value));
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
