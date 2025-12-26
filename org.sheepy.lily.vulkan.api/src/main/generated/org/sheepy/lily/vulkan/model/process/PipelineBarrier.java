package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PipelineBarrierBuilder;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.barrier.BarrierModelDefinition;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface PipelineBarrier extends IPipelineTask {
  static Builder builder() {
    return new PipelineBarrierBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Barrier> barriers();
  EPipelineStage srcStage();
  EPipelineStage dstStage();
  AbstractProcess srcQueue();
  AbstractProcess dstQueue();
  void srcStage(final EPipelineStage srcStage);
  void dstStage(final EPipelineStage dstStage);
  void srcQueue(final AbstractProcess srcQueue);
  void dstQueue(final AbstractProcess dstQueue);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int BARRIERS = 1278454210;
    int SRC_STAGE = -1708590688;
    int DST_STAGE = -706742689;
    int SRC_QUEUE = -1710403661;
    int DST_QUEUE = -708555662;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Relation<Barrier, List<Barrier>, Listener<List<Barrier>>, Features<?>> BARRIERS = new RelationBuilder<Barrier, List<Barrier>, Listener<List<Barrier>>, Features<?>>().name("barriers").many(true).mandatory(true).contains(true).id(PipelineBarrier.FeatureIDs.BARRIERS).concept(() -> BarrierModelDefinition.Groups.BARRIER).build();
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> SRC_STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("srcStage").id(PipelineBarrier.FeatureIDs.SRC_STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> DST_STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("dstStage").id(PipelineBarrier.FeatureIDs.DST_STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Relation<AbstractProcess, AbstractProcess, Listener<AbstractProcess>, Features<?>> SRC_QUEUE = new RelationBuilder<AbstractProcess, AbstractProcess, Listener<AbstractProcess>, Features<?>>().name("srcQueue").id(PipelineBarrier.FeatureIDs.SRC_QUEUE).concept(() -> ProcessModelDefinition.Groups.ABSTRACT_PROCESS).build();
    Relation<AbstractProcess, AbstractProcess, Listener<AbstractProcess>, Features<?>> DST_QUEUE = new RelationBuilder<AbstractProcess, AbstractProcess, Listener<AbstractProcess>, Features<?>>().name("dstQueue").id(PipelineBarrier.FeatureIDs.DST_QUEUE).concept(() -> ProcessModelDefinition.Groups.ABSTRACT_PROCESS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, BARRIERS, SRC_STAGE, DST_STAGE, SRC_QUEUE, DST_QUEUE);
  }

  interface Builder extends IFeaturedObject.Builder<PipelineBarrier> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder addBarrier(Supplier<Barrier> barrier);
    Builder srcStage(EPipelineStage srcStage);
    Builder dstStage(EPipelineStage dstStage);
    Builder srcQueue(Supplier<AbstractProcess> srcQueue);
    Builder dstQueue(Supplier<AbstractProcess> dstQueue);
    Builder addBarriers(List<Barrier> barriers);
  }
}
