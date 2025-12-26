package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteModelDefinition;

public final class SpriteImpl extends FeaturedObject<Sprite.Features<?>> implements Sprite {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<Sprite.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<PresentableEntity> presentedEntities = newObservableList(Presentation.FeatureIDs.PRESENTED_ENTITIES, true, false);
  private FileImage image;

  public SpriteImpl(final String name, final FileImage image) {
    this.name = name;
    this.image = image;
    setContainer(image, Sprite.FeatureIDs.IMAGE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Sprite.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<PresentableEntity> presentedEntities() {
    return presentedEntities;
  }

  @Override
  public FileImage image() {
    return image;
  }

  @Override
  public void image(final FileImage image) {
    final var oldValue = this.image;
    final var eventType = image == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.image = image;
    setContainer(image, Sprite.FeatureIDs.IMAGE);
    beforeContainmentNotify(eventType, oldValue, image);
    notifier.notify(Sprite.FeatureIDs.IMAGE, true, false, eventType, oldValue, image);
    afterContainmentNotify(eventType, oldValue, image);
  }

  @Override
  public Group<Sprite> lmGroup() {
    return SpriteModelDefinition.Groups.SPRITE;
  }

  @Override
  protected FeatureSetter<Sprite> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Sprite> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Sprite.FeatureIDs.NAME -> 0;
      case Sprite.FeatureIDs.PRESENTED_ENTITIES -> 1;
      case Sprite.FeatureIDs.IMAGE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Sprite> GET_MAP = new FeatureGetter.Builder<Sprite>(FEATURE_COUNT, SpriteImpl::featureIndexStatic).add(Sprite.FeatureIDs.NAME, Sprite::name).add(Sprite.FeatureIDs.PRESENTED_ENTITIES, Sprite::presentedEntities).add(Sprite.FeatureIDs.IMAGE, Sprite::image).build();
    private static final FeatureSetter<Sprite> SET_MAP = new FeatureSetter.Builder<Sprite>(FEATURE_COUNT, SpriteImpl::featureIndexStatic).add(Sprite.FeatureIDs.IMAGE, (object, value) -> ((SpriteImpl) object).image((FileImage) value)).build();
  }
}
