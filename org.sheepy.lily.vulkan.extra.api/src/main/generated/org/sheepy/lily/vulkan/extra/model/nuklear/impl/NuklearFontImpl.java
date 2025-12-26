package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearModelDefinition;

public final class NuklearFontImpl extends FeaturedObject<NuklearFont.Features<?>> implements NuklearFont {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<NuklearFont.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;

  public NuklearFontImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<NuklearFont.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Group<NuklearFont> lmGroup() {
    return NuklearModelDefinition.Groups.NUKLEAR_FONT;
  }

  @Override
  protected FeatureSetter<NuklearFont> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<NuklearFont> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case NuklearFont.FeatureIDs.NAME -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<NuklearFont> GET_MAP = new FeatureGetter.Builder<NuklearFont>(FEATURE_COUNT, NuklearFontImpl::featureIndexStatic).add(NuklearFont.FeatureIDs.NAME, NuklearFont::name).build();
    private static final FeatureSetter<NuklearFont> SET_MAP = new FeatureSetter.Builder<NuklearFont>(FEATURE_COUNT, NuklearFontImpl::featureIndexStatic).build();
  }
}
