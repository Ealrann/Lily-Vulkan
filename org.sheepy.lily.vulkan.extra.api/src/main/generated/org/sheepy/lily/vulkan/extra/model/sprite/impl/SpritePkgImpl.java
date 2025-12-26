package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteModelDefinition;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePkg;

public final class SpritePkgImpl extends FeaturedObject<SpritePkg.Features<?>> implements SpritePkg {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<SpritePkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<Sprite> sprites = newObservableList(SpritePkg.FeatureIDs.SPRITES, true, true);

  public SpritePkgImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SpritePkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<Sprite> sprites() {
    return sprites;
  }

  @Override
  public Group<SpritePkg> lmGroup() {
    return SpriteModelDefinition.Groups.SPRITE_PKG;
  }

  @Override
  protected FeatureSetter<SpritePkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SpritePkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SpritePkg.FeatureIDs.NAME -> 0;
      case SpritePkg.FeatureIDs.SPRITES -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SpritePkg> GET_MAP = new FeatureGetter.Builder<SpritePkg>(FEATURE_COUNT, SpritePkgImpl::featureIndexStatic).add(SpritePkg.FeatureIDs.NAME, SpritePkg::name).add(SpritePkg.FeatureIDs.SPRITES, SpritePkg::sprites).build();
    private static final FeatureSetter<SpritePkg> SET_MAP = new FeatureSetter.Builder<SpritePkg>(FEATURE_COUNT, SpritePkgImpl::featureIndexStatic).build();
  }
}
