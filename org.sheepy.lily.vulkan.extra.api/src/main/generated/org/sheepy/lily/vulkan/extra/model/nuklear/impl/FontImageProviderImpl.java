package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearModelDefinition;

public final class FontImageProviderImpl extends FeaturedObject<FontImageProvider.Features<?>> implements FontImageProvider {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<FontImageProvider.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private NuklearFont nuklearFont;

  public FontImageProviderImpl(final String name, final NuklearFont nuklearFont) {
    this.name = name;
    this.nuklearFont = nuklearFont;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FontImageProvider.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public NuklearFont nuklearFont() {
    return nuklearFont;
  }

  @Override
  public void nuklearFont(final NuklearFont nuklearFont) {
    final var oldValue = this.nuklearFont;
    final var eventType = nuklearFont == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.nuklearFont = nuklearFont;
    notifier.notify(FontImageProvider.FeatureIDs.NUKLEAR_FONT, false, false, eventType, oldValue, nuklearFont);
  }

  @Override
  public Group<FontImageProvider> lmGroup() {
    return NuklearModelDefinition.Groups.FONT_IMAGE_PROVIDER;
  }

  @Override
  protected FeatureSetter<FontImageProvider> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FontImageProvider> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FontImageProvider.FeatureIDs.NAME -> 0;
      case FontImageProvider.FeatureIDs.NUKLEAR_FONT -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FontImageProvider> GET_MAP = new FeatureGetter.Builder<FontImageProvider>(FEATURE_COUNT, FontImageProviderImpl::featureIndexStatic).add(FontImageProvider.FeatureIDs.NAME, FontImageProvider::name).add(FontImageProvider.FeatureIDs.NUKLEAR_FONT, FontImageProvider::nuklearFont).build();
    private static final FeatureSetter<FontImageProvider> SET_MAP = new FeatureSetter.Builder<FontImageProvider>(FEATURE_COUNT, FontImageProviderImpl::featureIndexStatic).add(FontImageProvider.FeatureIDs.NUKLEAR_FONT, (object, value) -> ((FontImageProviderImpl) object).nuklearFont((NuklearFont) value)).build();
  }
}
