package org.sheepy.vulkan.model.image.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;
import org.sheepy.vulkan.model.image.SamplerInfo;
import org.sheepy.vulkan.model.image.SamplerInfo.Builder;
import org.sheepy.vulkan.model.image.impl.SamplerInfoImpl;

public final class SamplerInfoBuilder implements Builder {
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

  public SamplerInfoBuilder() {
  }

  @Override
  public SamplerInfoBuilder minFilter(EFilter minFilter) {
    this.minFilter = minFilter;
    return this;
  }

  @Override
  public SamplerInfoBuilder magFilter(EFilter magFilter) {
    this.magFilter = magFilter;
    return this;
  }

  @Override
  public SamplerInfoBuilder mipmapMode(ESamplerMipmapMode mipmapMode) {
    this.mipmapMode = mipmapMode;
    return this;
  }

  @Override
  public SamplerInfoBuilder addressMode(ESamplerAddressMode addressMode) {
    this.addressMode = addressMode;
    return this;
  }

  @Override
  public SamplerInfoBuilder borderColor(EBorderColor borderColor) {
    this.borderColor = borderColor;
    return this;
  }

  @Override
  public SamplerInfoBuilder anisotropyEnabled(boolean anisotropyEnabled) {
    this.anisotropyEnabled = anisotropyEnabled;
    return this;
  }

  @Override
  public SamplerInfoBuilder unnormalizedCoordinates(boolean unnormalizedCoordinates) {
    this.unnormalizedCoordinates = unnormalizedCoordinates;
    return this;
  }

  @Override
  public SamplerInfoBuilder compareEnable(boolean compareEnable) {
    this.compareEnable = compareEnable;
    return this;
  }

  @Override
  public SamplerInfoBuilder lodBias(float lodBias) {
    this.lodBias = lodBias;
    return this;
  }

  @Override
  public SamplerInfoBuilder minLod(int minLod) {
    this.minLod = minLod;
    return this;
  }

  @Override
  public SamplerInfoBuilder maxLod(int maxLod) {
    this.maxLod = maxLod;
    return this;
  }

  @Override
  public SamplerInfoBuilder maxAnisotropy(float maxAnisotropy) {
    this.maxAnisotropy = maxAnisotropy;
    return this;
  }

  @Override
  public SamplerInfo build() {
    final var built = new SamplerInfoImpl();
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
    private static final FeatureInserter<SamplerInfoBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SamplerInfoBuilder>(12, Inserters::attributeIndex).add(SamplerInfo.FeatureIDs.MIN_FILTER, (builder, value) -> builder.minFilter((EFilter) value)).add(SamplerInfo.FeatureIDs.MAG_FILTER, (builder, value) -> builder.magFilter((EFilter) value)).add(SamplerInfo.FeatureIDs.MIPMAP_MODE, (builder, value) -> builder.mipmapMode((ESamplerMipmapMode) value)).add(SamplerInfo.FeatureIDs.ADDRESS_MODE, (builder, value) -> builder.addressMode((ESamplerAddressMode) value)).add(SamplerInfo.FeatureIDs.BORDER_COLOR, (builder, value) -> builder.borderColor((EBorderColor) value)).add(SamplerInfo.FeatureIDs.ANISOTROPY_ENABLED, (builder, value) -> builder.anisotropyEnabled((boolean) value)).add(SamplerInfo.FeatureIDs.UNNORMALIZED_COORDINATES, (builder, value) -> builder.unnormalizedCoordinates((boolean) value)).add(SamplerInfo.FeatureIDs.COMPARE_ENABLE, (builder, value) -> builder.compareEnable((boolean) value)).add(SamplerInfo.FeatureIDs.LOD_BIAS, (builder, value) -> builder.lodBias((float) value)).add(SamplerInfo.FeatureIDs.MIN_LOD, (builder, value) -> builder.minLod((int) value)).add(SamplerInfo.FeatureIDs.MAX_LOD, (builder, value) -> builder.maxLod((int) value)).add(SamplerInfo.FeatureIDs.MAX_ANISOTROPY, (builder, value) -> builder.maxAnisotropy((float) value)).build();
    private static final RelationLazyInserter<SamplerInfoBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SamplerInfoBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SamplerInfo.FeatureIDs.MIN_FILTER -> 0;
        case SamplerInfo.FeatureIDs.MAG_FILTER -> 1;
        case SamplerInfo.FeatureIDs.MIPMAP_MODE -> 2;
        case SamplerInfo.FeatureIDs.ADDRESS_MODE -> 3;
        case SamplerInfo.FeatureIDs.BORDER_COLOR -> 4;
        case SamplerInfo.FeatureIDs.ANISOTROPY_ENABLED -> 5;
        case SamplerInfo.FeatureIDs.UNNORMALIZED_COORDINATES -> 6;
        case SamplerInfo.FeatureIDs.COMPARE_ENABLE -> 7;
        case SamplerInfo.FeatureIDs.LOD_BIAS -> 8;
        case SamplerInfo.FeatureIDs.MIN_LOD -> 9;
        case SamplerInfo.FeatureIDs.MAX_LOD -> 10;
        case SamplerInfo.FeatureIDs.MAX_ANISOTROPY -> 11;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
