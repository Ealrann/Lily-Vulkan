package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class GraphicCommandBufferImpl extends FeaturedObject<GraphicCommandBuffer.Features<?>> implements GraphicCommandBuffer {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<GraphicCommandBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int index;
  private int imageID;

  public GraphicCommandBufferImpl(final int index, final int imageID) {
    this.index = index;
    this.imageID = imageID;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GraphicCommandBuffer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int index() {
    return index;
  }

  @Override
  public void index(final int index) {
    final var oldValue = this.index;
    this.index = index;
    notifier.notifyInt(ICommandBuffer.FeatureIDs.INDEX, false, false, oldValue, index);
  }

  @Override
  public int imageID() {
    return imageID;
  }

  @Override
  public void imageID(final int imageID) {
    final var oldValue = this.imageID;
    this.imageID = imageID;
    notifier.notifyInt(GraphicCommandBuffer.FeatureIDs.IMAGEID, false, false, oldValue, imageID);
  }

  @Override
  public Group<GraphicCommandBuffer> lmGroup() {
    return GraphicModelDefinition.Groups.GRAPHIC_COMMAND_BUFFER;
  }

  @Override
  protected FeatureSetter<GraphicCommandBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GraphicCommandBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GraphicCommandBuffer.FeatureIDs.INDEX -> 0;
      case GraphicCommandBuffer.FeatureIDs.IMAGEID -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GraphicCommandBuffer> GET_MAP = new FeatureGetter.Builder<GraphicCommandBuffer>(FEATURE_COUNT, GraphicCommandBufferImpl::featureIndexStatic).add(GraphicCommandBuffer.FeatureIDs.INDEX, GraphicCommandBuffer::index).add(GraphicCommandBuffer.FeatureIDs.IMAGEID, GraphicCommandBuffer::imageID).build();
    private static final FeatureSetter<GraphicCommandBuffer> SET_MAP = new FeatureSetter.Builder<GraphicCommandBuffer>(FEATURE_COUNT, GraphicCommandBufferImpl::featureIndexStatic).add(GraphicCommandBuffer.FeatureIDs.INDEX, (object, value) -> ((GraphicCommandBufferImpl) object).index((int) value)).add(GraphicCommandBuffer.FeatureIDs.IMAGEID, (object, value) -> ((GraphicCommandBufferImpl) object).imageID((int) value)).build();
  }
}
