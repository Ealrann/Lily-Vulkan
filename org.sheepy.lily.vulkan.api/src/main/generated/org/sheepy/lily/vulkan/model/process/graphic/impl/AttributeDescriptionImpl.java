package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.vulkan.model.enumeration.EFormat;

public final class AttributeDescriptionImpl extends FeaturedObject<AttributeDescription.Features<?>> implements AttributeDescription {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<AttributeDescription.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private EFormat format;
  private int offset;

  public AttributeDescriptionImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<AttributeDescription.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public EFormat format() {
    return format;
  }

  @Override
  public void format(final EFormat format) {
    final var oldValue = this.format;
    this.format = format;
    notifier.notify(AttributeDescription.FeatureIDs.FORMAT, false, false, oldValue, format);
  }

  @Override
  public int offset() {
    return offset;
  }

  @Override
  public void offset(final int offset) {
    final var oldValue = this.offset;
    this.offset = offset;
    notifier.notifyInt(AttributeDescription.FeatureIDs.OFFSET, false, false, oldValue, offset);
  }

  @Override
  public Group<AttributeDescription> lmGroup() {
    return GraphicModelDefinition.Groups.ATTRIBUTE_DESCRIPTION;
  }

  @Override
  protected FeatureSetter<AttributeDescription> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<AttributeDescription> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case AttributeDescription.FeatureIDs.NAME -> 0;
      case AttributeDescription.FeatureIDs.FORMAT -> 1;
      case AttributeDescription.FeatureIDs.OFFSET -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<AttributeDescription> GET_MAP = new FeatureGetter.Builder<AttributeDescription>(FEATURE_COUNT, AttributeDescriptionImpl::featureIndexStatic).add(AttributeDescription.FeatureIDs.NAME, AttributeDescription::name).add(AttributeDescription.FeatureIDs.FORMAT, AttributeDescription::format).add(AttributeDescription.FeatureIDs.OFFSET, AttributeDescription::offset).build();
    private static final FeatureSetter<AttributeDescription> SET_MAP = new FeatureSetter.Builder<AttributeDescription>(FEATURE_COUNT, AttributeDescriptionImpl::featureIndexStatic).add(AttributeDescription.FeatureIDs.FORMAT, (object, value) -> ((AttributeDescriptionImpl) object).format((EFormat) value)).add(AttributeDescription.FeatureIDs.OFFSET, (object, value) -> ((AttributeDescriptionImpl) object).offset((int) value)).build();
  }
}
