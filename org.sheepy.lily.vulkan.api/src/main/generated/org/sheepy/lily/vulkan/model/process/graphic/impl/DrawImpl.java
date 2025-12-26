package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class DrawImpl extends FeaturedObject<Draw.Features<?>> implements Draw {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<Draw.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private int vertexCount;
  private int instanceCount;
  private int firstVertex;
  private int firstInstance;

  public DrawImpl(final String name, final int vertexCount) {
    this.name = name;
    this.vertexCount = vertexCount;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Draw.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(IPipelineTask.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public int vertexCount() {
    return vertexCount;
  }

  @Override
  public void vertexCount(final int vertexCount) {
    final var oldValue = this.vertexCount;
    this.vertexCount = vertexCount;
    notifier.notifyInt(Draw.FeatureIDs.VERTEX_COUNT, false, false, oldValue, vertexCount);
  }

  @Override
  public int instanceCount() {
    return instanceCount;
  }

  @Override
  public void instanceCount(final int instanceCount) {
    final var oldValue = this.instanceCount;
    this.instanceCount = instanceCount;
    notifier.notifyInt(Draw.FeatureIDs.INSTANCE_COUNT, false, false, oldValue, instanceCount);
  }

  @Override
  public int firstVertex() {
    return firstVertex;
  }

  @Override
  public void firstVertex(final int firstVertex) {
    final var oldValue = this.firstVertex;
    this.firstVertex = firstVertex;
    notifier.notifyInt(Draw.FeatureIDs.FIRST_VERTEX, false, false, oldValue, firstVertex);
  }

  @Override
  public int firstInstance() {
    return firstInstance;
  }

  @Override
  public void firstInstance(final int firstInstance) {
    final var oldValue = this.firstInstance;
    this.firstInstance = firstInstance;
    notifier.notifyInt(Draw.FeatureIDs.FIRST_INSTANCE, false, false, oldValue, firstInstance);
  }

  @Override
  public Group<Draw> lmGroup() {
    return GraphicModelDefinition.Groups.DRAW;
  }

  @Override
  protected FeatureSetter<Draw> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Draw> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Draw.FeatureIDs.NAME -> 0;
      case Draw.FeatureIDs.ENABLED -> 1;
      case Draw.FeatureIDs.VERTEX_COUNT -> 2;
      case Draw.FeatureIDs.INSTANCE_COUNT -> 3;
      case Draw.FeatureIDs.FIRST_VERTEX -> 4;
      case Draw.FeatureIDs.FIRST_INSTANCE -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Draw> GET_MAP = new FeatureGetter.Builder<Draw>(FEATURE_COUNT, DrawImpl::featureIndexStatic).add(Draw.FeatureIDs.NAME, Draw::name).add(Draw.FeatureIDs.ENABLED, Draw::enabled).add(Draw.FeatureIDs.VERTEX_COUNT, Draw::vertexCount).add(Draw.FeatureIDs.INSTANCE_COUNT, Draw::instanceCount).add(Draw.FeatureIDs.FIRST_VERTEX, Draw::firstVertex).add(Draw.FeatureIDs.FIRST_INSTANCE, Draw::firstInstance).build();
    private static final FeatureSetter<Draw> SET_MAP = new FeatureSetter.Builder<Draw>(FEATURE_COUNT, DrawImpl::featureIndexStatic).add(Draw.FeatureIDs.ENABLED, (object, value) -> ((DrawImpl) object).enabled((boolean) value)).add(Draw.FeatureIDs.VERTEX_COUNT, (object, value) -> ((DrawImpl) object).vertexCount((int) value)).add(Draw.FeatureIDs.INSTANCE_COUNT, (object, value) -> ((DrawImpl) object).instanceCount((int) value)).add(Draw.FeatureIDs.FIRST_VERTEX, (object, value) -> ((DrawImpl) object).firstVertex((int) value)).add(Draw.FeatureIDs.FIRST_INSTANCE, (object, value) -> ((DrawImpl) object).firstInstance((int) value)).build();
  }
}
