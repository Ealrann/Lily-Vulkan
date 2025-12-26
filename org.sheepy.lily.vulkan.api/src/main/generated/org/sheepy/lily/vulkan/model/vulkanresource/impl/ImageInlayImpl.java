package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class ImageInlayImpl extends FeaturedObject<ImageInlay.Features<?>> implements ImageInlay {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<ImageInlay.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private IVulkanImage image;
  private Vector2ic position;
  private float size;
  private EHorizontalRelative horizontalRelative;
  private EVerticalRelative verticalRelative;

  public ImageInlayImpl(final IVulkanImage image, final Vector2ic position, final float size,
      final EHorizontalRelative horizontalRelative, final EVerticalRelative verticalRelative) {
    this.image = image;
    this.position = position;
    this.size = size;
    this.horizontalRelative = horizontalRelative;
    this.verticalRelative = verticalRelative;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageInlay.Features<?>> notifier() {
    return notifier;
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
    notifier.notify(ImageInlay.FeatureIDs.IMAGE, false, false, eventType, oldValue, image);
  }

  @Override
  public Vector2ic position() {
    return position;
  }

  @Override
  public void position(final Vector2ic position) {
    final var oldValue = this.position;
    this.position = position;
    notifier.notify(ImageInlay.FeatureIDs.POSITION, false, false, oldValue, position);
  }

  @Override
  public float size() {
    return size;
  }

  @Override
  public void size(final float size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notifyFloat(ImageInlay.FeatureIDs.SIZE, false, false, oldValue, size);
  }

  @Override
  public EHorizontalRelative horizontalRelative() {
    return horizontalRelative;
  }

  @Override
  public void horizontalRelative(final EHorizontalRelative horizontalRelative) {
    final var oldValue = this.horizontalRelative;
    this.horizontalRelative = horizontalRelative;
    notifier.notify(ImageInlay.FeatureIDs.HORIZONTAL_RELATIVE, false, false, oldValue, horizontalRelative);
  }

  @Override
  public EVerticalRelative verticalRelative() {
    return verticalRelative;
  }

  @Override
  public void verticalRelative(final EVerticalRelative verticalRelative) {
    final var oldValue = this.verticalRelative;
    this.verticalRelative = verticalRelative;
    notifier.notify(ImageInlay.FeatureIDs.VERTICAL_RELATIVE, false, false, oldValue, verticalRelative);
  }

  @Override
  public Group<ImageInlay> lmGroup() {
    return VulkanResourceModelDefinition.Groups.IMAGE_INLAY;
  }

  @Override
  protected FeatureSetter<ImageInlay> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageInlay> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ImageInlay.FeatureIDs.IMAGE -> 0;
      case ImageInlay.FeatureIDs.POSITION -> 1;
      case ImageInlay.FeatureIDs.SIZE -> 2;
      case ImageInlay.FeatureIDs.HORIZONTAL_RELATIVE -> 3;
      case ImageInlay.FeatureIDs.VERTICAL_RELATIVE -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageInlay> GET_MAP = new FeatureGetter.Builder<ImageInlay>(FEATURE_COUNT, ImageInlayImpl::featureIndexStatic).add(ImageInlay.FeatureIDs.IMAGE, ImageInlay::image).add(ImageInlay.FeatureIDs.POSITION, ImageInlay::position).add(ImageInlay.FeatureIDs.SIZE, ImageInlay::size).add(ImageInlay.FeatureIDs.HORIZONTAL_RELATIVE, ImageInlay::horizontalRelative).add(ImageInlay.FeatureIDs.VERTICAL_RELATIVE, ImageInlay::verticalRelative).build();
    private static final FeatureSetter<ImageInlay> SET_MAP = new FeatureSetter.Builder<ImageInlay>(FEATURE_COUNT, ImageInlayImpl::featureIndexStatic).add(ImageInlay.FeatureIDs.IMAGE, (object, value) -> ((ImageInlayImpl) object).image((IVulkanImage) value)).add(ImageInlay.FeatureIDs.POSITION, (object, value) -> ((ImageInlayImpl) object).position((Vector2ic) value)).add(ImageInlay.FeatureIDs.SIZE, (object, value) -> ((ImageInlayImpl) object).size((float) value)).add(ImageInlay.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((ImageInlayImpl) object).horizontalRelative((EHorizontalRelative) value)).add(ImageInlay.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((ImageInlayImpl) object).verticalRelative((EVerticalRelative) value)).build();
  }
}
