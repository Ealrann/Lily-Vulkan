package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EBorderColor;
import org.sheepy.vulkan.model.enumeration.EFilter;
import org.sheepy.vulkan.model.enumeration.ESamplerAddressMode;
import org.sheepy.vulkan.model.enumeration.ESamplerMipmapMode;
import org.sheepy.vulkan.model.image.SamplerInfo;

public final class SamplerImpl extends FeaturedObject<Sampler.Features<?>> implements Sampler {
  private static final int FEATURE_COUNT = 14;
  private final ModelNotifier<Sampler.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
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
  private IVulkanImage image;

  public SamplerImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Sampler.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
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
  public IVulkanImage image() {
    return image;
  }

  @Override
  public void image(final IVulkanImage image) {
    final var oldValue = this.image;
    final var eventType = image == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.image = image;
    notifier.notify(Sampler.FeatureIDs.IMAGE, false, false, eventType, oldValue, image);
  }

  @Override
  public Group<Sampler> lmGroup() {
    return VulkanResourceModelDefinition.Groups.SAMPLER;
  }

  @Override
  protected FeatureSetter<Sampler> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Sampler> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
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
      case Sampler.FeatureIDs.IMAGE -> 13;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Sampler> GET_MAP = new FeatureGetter.Builder<Sampler>(FEATURE_COUNT, SamplerImpl::featureIndexStatic).add(Sampler.FeatureIDs.NAME, Sampler::name).add(Sampler.FeatureIDs.MIN_FILTER, Sampler::minFilter).add(Sampler.FeatureIDs.MAG_FILTER, Sampler::magFilter).add(Sampler.FeatureIDs.MIPMAP_MODE, Sampler::mipmapMode).add(Sampler.FeatureIDs.ADDRESS_MODE, Sampler::addressMode).add(Sampler.FeatureIDs.BORDER_COLOR, Sampler::borderColor).add(Sampler.FeatureIDs.ANISOTROPY_ENABLED, Sampler::anisotropyEnabled).add(Sampler.FeatureIDs.UNNORMALIZED_COORDINATES, Sampler::unnormalizedCoordinates).add(Sampler.FeatureIDs.COMPARE_ENABLE, Sampler::compareEnable).add(Sampler.FeatureIDs.LOD_BIAS, Sampler::lodBias).add(Sampler.FeatureIDs.MIN_LOD, Sampler::minLod).add(Sampler.FeatureIDs.MAX_LOD, Sampler::maxLod).add(Sampler.FeatureIDs.MAX_ANISOTROPY, Sampler::maxAnisotropy).add(Sampler.FeatureIDs.IMAGE, Sampler::image).build();
    private static final FeatureSetter<Sampler> SET_MAP = new FeatureSetter.Builder<Sampler>(FEATURE_COUNT, SamplerImpl::featureIndexStatic).add(Sampler.FeatureIDs.MIN_FILTER, (object, value) -> ((SamplerImpl) object).minFilter((EFilter) value)).add(Sampler.FeatureIDs.MAG_FILTER, (object, value) -> ((SamplerImpl) object).magFilter((EFilter) value)).add(Sampler.FeatureIDs.MIPMAP_MODE, (object, value) -> ((SamplerImpl) object).mipmapMode((ESamplerMipmapMode) value)).add(Sampler.FeatureIDs.ADDRESS_MODE, (object, value) -> ((SamplerImpl) object).addressMode((ESamplerAddressMode) value)).add(Sampler.FeatureIDs.BORDER_COLOR, (object, value) -> ((SamplerImpl) object).borderColor((EBorderColor) value)).add(Sampler.FeatureIDs.ANISOTROPY_ENABLED, (object, value) -> ((SamplerImpl) object).anisotropyEnabled((boolean) value)).add(Sampler.FeatureIDs.UNNORMALIZED_COORDINATES, (object, value) -> ((SamplerImpl) object).unnormalizedCoordinates((boolean) value)).add(Sampler.FeatureIDs.COMPARE_ENABLE, (object, value) -> ((SamplerImpl) object).compareEnable((boolean) value)).add(Sampler.FeatureIDs.LOD_BIAS, (object, value) -> ((SamplerImpl) object).lodBias((float) value)).add(Sampler.FeatureIDs.MIN_LOD, (object, value) -> ((SamplerImpl) object).minLod((int) value)).add(Sampler.FeatureIDs.MAX_LOD, (object, value) -> ((SamplerImpl) object).maxLod((int) value)).add(Sampler.FeatureIDs.MAX_ANISOTROPY, (object, value) -> ((SamplerImpl) object).maxAnisotropy((float) value)).add(Sampler.FeatureIDs.IMAGE, (object, value) -> ((SamplerImpl) object).image((IVulkanImage) value)).build();
  }
}
