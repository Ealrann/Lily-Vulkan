package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.SamplerImpl;
import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;

public final class SamplerBuilder implements Builder {
  private String name;
  private EFilter minFilter = EFilter.NEAREST;
  private EFilter magFilter = EFilter.NEAREST;
  private ESamplerMipmapMode mipmapMode = ESamplerMipmapMode.NEAREST;
  private ESamplerAddressMode addressMode = ESamplerAddressMode.REPEAT;
  private EBorderColor borderColor = EBorderColor.INT_OPAQUE_BLACK;
  private boolean anisotropyEnabled = false;
  private boolean unnormalizedCoordinates = false;
  private boolean compareEnable = false;
  private float lodBias = 0f;
  private int minLod = 0;
  private int maxLod = 1;
  private float maxAnisotropy = 1f;
  private Supplier<IVulkanImage> image = () -> null;

  public SamplerBuilder() {
  }

  @Override
  public SamplerBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SamplerBuilder minFilter(EFilter minFilter) {
    this.minFilter = minFilter;
    return this;
  }

  @Override
  public SamplerBuilder magFilter(EFilter magFilter) {
    this.magFilter = magFilter;
    return this;
  }

  @Override
  public SamplerBuilder mipmapMode(ESamplerMipmapMode mipmapMode) {
    this.mipmapMode = mipmapMode;
    return this;
  }

  @Override
  public SamplerBuilder addressMode(ESamplerAddressMode addressMode) {
    this.addressMode = addressMode;
    return this;
  }

  @Override
  public SamplerBuilder borderColor(EBorderColor borderColor) {
    this.borderColor = borderColor;
    return this;
  }

  @Override
  public SamplerBuilder anisotropyEnabled(boolean anisotropyEnabled) {
    this.anisotropyEnabled = anisotropyEnabled;
    return this;
  }

  @Override
  public SamplerBuilder unnormalizedCoordinates(boolean unnormalizedCoordinates) {
    this.unnormalizedCoordinates = unnormalizedCoordinates;
    return this;
  }

  @Override
  public SamplerBuilder compareEnable(boolean compareEnable) {
    this.compareEnable = compareEnable;
    return this;
  }

  @Override
  public SamplerBuilder lodBias(float lodBias) {
    this.lodBias = lodBias;
    return this;
  }

  @Override
  public SamplerBuilder minLod(int minLod) {
    this.minLod = minLod;
    return this;
  }

  @Override
  public SamplerBuilder maxLod(int maxLod) {
    this.maxLod = maxLod;
    return this;
  }

  @Override
  public SamplerBuilder maxAnisotropy(float maxAnisotropy) {
    this.maxAnisotropy = maxAnisotropy;
    return this;
  }

  @Override
  public SamplerBuilder image(Supplier<IVulkanImage> image) {
    this.image = image;
    return this;
  }

  @Override
  public Sampler build() {
    final var built = new SamplerImpl(name);
    built.minFilter(minFilter);
    built.magFilter(magFilter);
    built.mipmapMode(mipmapMode);
    built.addressMode(addressMode);
    built.borderColor(borderColor);
    built.anisotropyEnabled(anisotropyEnabled);
    built.unnormalizedCoordinates(unnormalizedCoordinates);
    built.compareEnable(compareEnable);
    built.lodBias(lodBias);
    built.minLod(minLod);
    built.maxLod(maxLod);
    built.maxAnisotropy(maxAnisotropy);
    built.image(image.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<SamplerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SamplerBuilder>(13, Inserters::attributeIndex).add(Sampler.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Sampler.FeatureIDs.MIN_FILTER, (builder, value) -> builder.minFilter((EFilter) value)).add(Sampler.FeatureIDs.MAG_FILTER, (builder, value) -> builder.magFilter((EFilter) value)).add(Sampler.FeatureIDs.MIPMAP_MODE, (builder, value) -> builder.mipmapMode((ESamplerMipmapMode) value)).add(Sampler.FeatureIDs.ADDRESS_MODE, (builder, value) -> builder.addressMode((ESamplerAddressMode) value)).add(Sampler.FeatureIDs.BORDER_COLOR, (builder, value) -> builder.borderColor((EBorderColor) value)).add(Sampler.FeatureIDs.ANISOTROPY_ENABLED, (builder, value) -> builder.anisotropyEnabled((boolean) value)).add(Sampler.FeatureIDs.UNNORMALIZED_COORDINATES, (builder, value) -> builder.unnormalizedCoordinates((boolean) value)).add(Sampler.FeatureIDs.COMPARE_ENABLE, (builder, value) -> builder.compareEnable((boolean) value)).add(Sampler.FeatureIDs.LOD_BIAS, (builder, value) -> builder.lodBias((float) value)).add(Sampler.FeatureIDs.MIN_LOD, (builder, value) -> builder.minLod((int) value)).add(Sampler.FeatureIDs.MAX_LOD, (builder, value) -> builder.maxLod((int) value)).add(Sampler.FeatureIDs.MAX_ANISOTROPY, (builder, value) -> builder.maxAnisotropy((float) value)).build();
    private static final RelationLazyInserter<SamplerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SamplerBuilder>(1, Inserters::relationIndex).add(Sampler.FeatureIDs.IMAGE, (builder, value) -> builder.image((Supplier<IVulkanImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Sampler.FeatureIDs.NAME -> 0;
        case Sampler.FeatureIDs.MIN_FILTER -> 1;
        case Sampler.FeatureIDs.MAG_FILTER -> 2;
        case Sampler.FeatureIDs.MIPMAP_MODE -> 3;
        case Sampler.FeatureIDs.ADDRESS_MODE -> 4;
        case Sampler.FeatureIDs.BORDER_COLOR -> 5;
        case Sampler.FeatureIDs.ANISOTROPY_ENABLED -> 6;
        case Sampler.FeatureIDs.UNNORMALIZED_COORDINATES -> 7;
        case Sampler.FeatureIDs.COMPARE_ENABLE -> 8;
        case Sampler.FeatureIDs.LOD_BIAS -> 9;
        case Sampler.FeatureIDs.MIN_LOD -> 10;
        case Sampler.FeatureIDs.MAX_LOD -> 11;
        case Sampler.FeatureIDs.MAX_ANISOTROPY -> 12;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Sampler.FeatureIDs.IMAGE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
