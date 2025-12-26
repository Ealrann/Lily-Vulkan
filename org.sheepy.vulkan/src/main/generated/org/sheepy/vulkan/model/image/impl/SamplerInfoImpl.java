package org.sheepy.vulkan.model.image.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;
import org.sheepy.vulkan.model.image.ImageModelDefinition;
import org.sheepy.vulkan.model.image.SamplerInfo;

public final class SamplerInfoImpl extends FeaturedObject<SamplerInfo.Features<?>> implements SamplerInfo {
  private static final int FEATURE_COUNT = 12;
  private final ModelNotifier<SamplerInfo.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private EFilter minFilter;
  private EFilter magFilter;
  private ESamplerMipmapMode mipmapMode;
  private ESamplerAddressMode addressMode;
  private EBorderColor borderColor;
  private boolean anisotropyEnabled;
  private boolean unnormalizedCoordinates;
  private boolean compareEnable;
  private float lodBias;
  private int minLod;
  private int maxLod;
  private float maxAnisotropy;

  public SamplerInfoImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SamplerInfo.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public EFilter minFilter() {
    return minFilter;
  }

  @Override
  public void minFilter(final EFilter minFilter) {
    final var oldValue = this.minFilter;
    this.minFilter = minFilter;
    notifier.notify(SamplerInfo.FeatureIDs.MIN_FILTER, false, false, oldValue, minFilter);
  }

  @Override
  public EFilter magFilter() {
    return magFilter;
  }

  @Override
  public void magFilter(final EFilter magFilter) {
    final var oldValue = this.magFilter;
    this.magFilter = magFilter;
    notifier.notify(SamplerInfo.FeatureIDs.MAG_FILTER, false, false, oldValue, magFilter);
  }

  @Override
  public ESamplerMipmapMode mipmapMode() {
    return mipmapMode;
  }

  @Override
  public void mipmapMode(final ESamplerMipmapMode mipmapMode) {
    final var oldValue = this.mipmapMode;
    this.mipmapMode = mipmapMode;
    notifier.notify(SamplerInfo.FeatureIDs.MIPMAP_MODE, false, false, oldValue, mipmapMode);
  }

  @Override
  public ESamplerAddressMode addressMode() {
    return addressMode;
  }

  @Override
  public void addressMode(final ESamplerAddressMode addressMode) {
    final var oldValue = this.addressMode;
    this.addressMode = addressMode;
    notifier.notify(SamplerInfo.FeatureIDs.ADDRESS_MODE, false, false, oldValue, addressMode);
  }

  @Override
  public EBorderColor borderColor() {
    return borderColor;
  }

  @Override
  public void borderColor(final EBorderColor borderColor) {
    final var oldValue = this.borderColor;
    this.borderColor = borderColor;
    notifier.notify(SamplerInfo.FeatureIDs.BORDER_COLOR, false, false, oldValue, borderColor);
  }

  @Override
  public boolean anisotropyEnabled() {
    return anisotropyEnabled;
  }

  @Override
  public void anisotropyEnabled(final boolean anisotropyEnabled) {
    final var oldValue = this.anisotropyEnabled;
    this.anisotropyEnabled = anisotropyEnabled;
    notifier.notifyBoolean(SamplerInfo.FeatureIDs.ANISOTROPY_ENABLED, false, false, oldValue, anisotropyEnabled);
  }

  @Override
  public boolean unnormalizedCoordinates() {
    return unnormalizedCoordinates;
  }

  @Override
  public void unnormalizedCoordinates(final boolean unnormalizedCoordinates) {
    final var oldValue = this.unnormalizedCoordinates;
    this.unnormalizedCoordinates = unnormalizedCoordinates;
    notifier.notifyBoolean(SamplerInfo.FeatureIDs.UNNORMALIZED_COORDINATES, false, false, oldValue, unnormalizedCoordinates);
  }

  @Override
  public boolean compareEnable() {
    return compareEnable;
  }

  @Override
  public void compareEnable(final boolean compareEnable) {
    final var oldValue = this.compareEnable;
    this.compareEnable = compareEnable;
    notifier.notifyBoolean(SamplerInfo.FeatureIDs.COMPARE_ENABLE, false, false, oldValue, compareEnable);
  }

  @Override
  public float lodBias() {
    return lodBias;
  }

  @Override
  public void lodBias(final float lodBias) {
    final var oldValue = this.lodBias;
    this.lodBias = lodBias;
    notifier.notifyFloat(SamplerInfo.FeatureIDs.LOD_BIAS, false, false, oldValue, lodBias);
  }

  @Override
  public int minLod() {
    return minLod;
  }

  @Override
  public void minLod(final int minLod) {
    final var oldValue = this.minLod;
    this.minLod = minLod;
    notifier.notifyInt(SamplerInfo.FeatureIDs.MIN_LOD, false, false, oldValue, minLod);
  }

  @Override
  public int maxLod() {
    return maxLod;
  }

  @Override
  public void maxLod(final int maxLod) {
    final var oldValue = this.maxLod;
    this.maxLod = maxLod;
    notifier.notifyInt(SamplerInfo.FeatureIDs.MAX_LOD, false, false, oldValue, maxLod);
  }

  @Override
  public float maxAnisotropy() {
    return maxAnisotropy;
  }

  @Override
  public void maxAnisotropy(final float maxAnisotropy) {
    final var oldValue = this.maxAnisotropy;
    this.maxAnisotropy = maxAnisotropy;
    notifier.notifyFloat(SamplerInfo.FeatureIDs.MAX_ANISOTROPY, false, false, oldValue, maxAnisotropy);
  }

  @Override
  public Group<SamplerInfo> lmGroup() {
    return ImageModelDefinition.Groups.SAMPLER_INFO;
  }

  @Override
  protected FeatureSetter<SamplerInfo> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SamplerInfo> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
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
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SamplerInfo> GET_MAP = new FeatureGetter.Builder<SamplerInfo>(FEATURE_COUNT, SamplerInfoImpl::featureIndexStatic).add(SamplerInfo.FeatureIDs.MIN_FILTER, SamplerInfo::minFilter).add(SamplerInfo.FeatureIDs.MAG_FILTER, SamplerInfo::magFilter).add(SamplerInfo.FeatureIDs.MIPMAP_MODE, SamplerInfo::mipmapMode).add(SamplerInfo.FeatureIDs.ADDRESS_MODE, SamplerInfo::addressMode).add(SamplerInfo.FeatureIDs.BORDER_COLOR, SamplerInfo::borderColor).add(SamplerInfo.FeatureIDs.ANISOTROPY_ENABLED, SamplerInfo::anisotropyEnabled).add(SamplerInfo.FeatureIDs.UNNORMALIZED_COORDINATES, SamplerInfo::unnormalizedCoordinates).add(SamplerInfo.FeatureIDs.COMPARE_ENABLE, SamplerInfo::compareEnable).add(SamplerInfo.FeatureIDs.LOD_BIAS, SamplerInfo::lodBias).add(SamplerInfo.FeatureIDs.MIN_LOD, SamplerInfo::minLod).add(SamplerInfo.FeatureIDs.MAX_LOD, SamplerInfo::maxLod).add(SamplerInfo.FeatureIDs.MAX_ANISOTROPY, SamplerInfo::maxAnisotropy).build();
    private static final FeatureSetter<SamplerInfo> SET_MAP = new FeatureSetter.Builder<SamplerInfo>(FEATURE_COUNT, SamplerInfoImpl::featureIndexStatic).add(SamplerInfo.FeatureIDs.MIN_FILTER, (object, value) -> ((SamplerInfoImpl) object).minFilter((EFilter) value)).add(SamplerInfo.FeatureIDs.MAG_FILTER, (object, value) -> ((SamplerInfoImpl) object).magFilter((EFilter) value)).add(SamplerInfo.FeatureIDs.MIPMAP_MODE, (object, value) -> ((SamplerInfoImpl) object).mipmapMode((ESamplerMipmapMode) value)).add(SamplerInfo.FeatureIDs.ADDRESS_MODE, (object, value) -> ((SamplerInfoImpl) object).addressMode((ESamplerAddressMode) value)).add(SamplerInfo.FeatureIDs.BORDER_COLOR, (object, value) -> ((SamplerInfoImpl) object).borderColor((EBorderColor) value)).add(SamplerInfo.FeatureIDs.ANISOTROPY_ENABLED, (object, value) -> ((SamplerInfoImpl) object).anisotropyEnabled((boolean) value)).add(SamplerInfo.FeatureIDs.UNNORMALIZED_COORDINATES, (object, value) -> ((SamplerInfoImpl) object).unnormalizedCoordinates((boolean) value)).add(SamplerInfo.FeatureIDs.COMPARE_ENABLE, (object, value) -> ((SamplerInfoImpl) object).compareEnable((boolean) value)).add(SamplerInfo.FeatureIDs.LOD_BIAS, (object, value) -> ((SamplerInfoImpl) object).lodBias((float) value)).add(SamplerInfo.FeatureIDs.MIN_LOD, (object, value) -> ((SamplerInfoImpl) object).minLod((int) value)).add(SamplerInfo.FeatureIDs.MAX_LOD, (object, value) -> ((SamplerInfoImpl) object).maxLod((int) value)).add(SamplerInfo.FeatureIDs.MAX_ANISOTROPY, (object, value) -> ((SamplerInfoImpl) object).maxAnisotropy((float) value)).build();
  }
}
