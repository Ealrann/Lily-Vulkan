package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PipelinePkgBuilder;

public interface PipelinePkg extends LMObject {
  static Builder builder() {
    return new PipelinePkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<AbstractPipeline> pipelines();

  interface FeatureIDs {
    int PIPELINES = 1839965952;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<AbstractPipeline, List<AbstractPipeline>, Listener<List<AbstractPipeline>>, Features<?>> PIPELINES = new RelationBuilder<AbstractPipeline, List<AbstractPipeline>, Listener<List<AbstractPipeline>>, Features<?>>().name("pipelines").many(true).contains(true).id(PipelinePkg.FeatureIDs.PIPELINES).concept(() -> ProcessModelDefinition.Groups.ABSTRACT_PIPELINE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PIPELINES);
  }

  interface Builder extends IFeaturedObject.Builder<PipelinePkg> {
    Builder addPipeline(Supplier<AbstractPipeline> pipeline);
    Builder addPipelines(List<AbstractPipeline> pipelines);
  }
}
