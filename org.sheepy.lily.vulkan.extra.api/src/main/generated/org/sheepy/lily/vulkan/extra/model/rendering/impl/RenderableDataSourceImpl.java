package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;

public final class RenderableDataSourceImpl<T extends Structure> extends FeaturedObject<RenderableDataSource.Features<?>> implements RenderableDataSource<T> {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<RenderableDataSource.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private T structure;
  private int part;
  private IBufferDataSource dataSource;

  public RenderableDataSourceImpl(final String name, final T structure, final int part) {
    this.name = name;
    this.structure = structure;
    this.part = part;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<RenderableDataSource.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public T structure() {
    return structure;
  }

  @Override
  public void structure(final T structure) {
    final var oldValue = this.structure;
    final var eventType = structure == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.structure = structure;
    notifier.notify(RenderableDataSource.FeatureIDs.STRUCTURE, false, false, eventType, oldValue, structure);
  }

  @Override
  public int part() {
    return part;
  }

  @Override
  public void part(final int part) {
    final var oldValue = this.part;
    this.part = part;
    notifier.notifyInt(RenderableDataSource.FeatureIDs.PART, false, false, oldValue, part);
  }

  @Override
  public IBufferDataSource dataSource() {
    return dataSource;
  }

  @Override
  public void dataSource(final IBufferDataSource dataSource) {
    final var oldValue = this.dataSource;
    final var eventType = dataSource == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dataSource = dataSource;
    notifier.notify(RenderableDataSource.FeatureIDs.DATA_SOURCE, false, false, eventType, oldValue, dataSource);
  }

  @Override
  public Group<RenderableDataSource<?>> lmGroup() {
    return RenderingModelDefinition.Groups.RENDERABLE_DATA_SOURCE;
  }

  @Override
  protected FeatureSetter<RenderableDataSource<?>> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<RenderableDataSource<?>> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case RenderableDataSource.FeatureIDs.NAME -> 0;
      case RenderableDataSource.FeatureIDs.STRUCTURE -> 1;
      case RenderableDataSource.FeatureIDs.PART -> 2;
      case RenderableDataSource.FeatureIDs.DATA_SOURCE -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<RenderableDataSource<?>> GET_MAP = new FeatureGetter.Builder<RenderableDataSource<?>>(FEATURE_COUNT, RenderableDataSourceImpl::featureIndexStatic).add(RenderableDataSource.FeatureIDs.NAME, RenderableDataSource::name).add(RenderableDataSource.FeatureIDs.STRUCTURE, RenderableDataSource::structure).add(RenderableDataSource.FeatureIDs.PART, RenderableDataSource::part).add(RenderableDataSource.FeatureIDs.DATA_SOURCE, RenderableDataSource::dataSource).build();
    private static final FeatureSetter<RenderableDataSource<?>> SET_MAP = new FeatureSetter.Builder<RenderableDataSource<?>>(FEATURE_COUNT, RenderableDataSourceImpl::featureIndexStatic).add(RenderableDataSource.FeatureIDs.STRUCTURE, (object, value) -> ((RenderableDataSourceImpl) object).structure((Structure) value)).add(RenderableDataSource.FeatureIDs.PART, (object, value) -> ((RenderableDataSourceImpl) object).part((int) value)).add(RenderableDataSource.FeatureIDs.DATA_SOURCE, (object, value) -> ((RenderableDataSourceImpl) object).dataSource((IBufferDataSource) value)).build();
  }
}
