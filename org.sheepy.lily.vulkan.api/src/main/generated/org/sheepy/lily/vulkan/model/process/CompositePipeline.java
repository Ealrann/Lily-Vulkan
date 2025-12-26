package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.CompositePipelineBuilder;

public interface CompositePipeline extends AbstractPipeline {
  static Builder builder() {
    return new CompositePipelineBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<TaskPipeline> pipelines();
  int repeat();
  void repeat(final int repeat);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ALLOCATE = AbstractPipeline.FeatureIDs.ALLOCATE;
    int RECORD = AbstractPipeline.FeatureIDs.RECORD;
    int EXTENSION_PKG = AbstractPipeline.FeatureIDs.EXTENSION_PKG;
    int PIPELINES = 561624959;
    int REPEAT = -1960327443;
  }

  interface Features<T extends Features<T>> extends AbstractPipeline.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> ALLOCATE = AbstractPipeline.Features.ALLOCATE;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> RECORD = AbstractPipeline.Features.RECORD;
    Relation<PipelineExtensionPkg, PipelineExtensionPkg, Listener<PipelineExtensionPkg>, AbstractPipeline.Features<?>> EXTENSION_PKG = AbstractPipeline.Features.EXTENSION_PKG;
    Relation<TaskPipeline, List<TaskPipeline>, Listener<List<TaskPipeline>>, Features<?>> PIPELINES = new RelationBuilder<TaskPipeline, List<TaskPipeline>, Listener<List<TaskPipeline>>, Features<?>>().name("pipelines").many(true).contains(true).id(CompositePipeline.FeatureIDs.PIPELINES).concept(() -> ProcessModelDefinition.Groups.TASK_PIPELINE).build();
    Attribute<Integer, Integer, IntListener, Features<?>> REPEAT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("repeat").mandatory(true).defaultValue("1").id(CompositePipeline.FeatureIDs.REPEAT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ALLOCATE, RECORD, EXTENSION_PKG, PIPELINES, REPEAT);
  }

  interface Builder extends IFeaturedObject.Builder<CompositePipeline> {
    Builder name(String name);
    Builder allocate(boolean allocate);
    Builder record(boolean record);
    Builder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg);
    Builder addPipeline(Supplier<TaskPipeline> pipeline);
    Builder repeat(int repeat);
    Builder addPipelines(List<TaskPipeline> pipelines);
  }
}
