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
import org.sheepy.lily.vulkan.model.process.builder.PipelineExtensionPkgBuilder;

public interface PipelineExtensionPkg extends LMObject {
  static Builder builder() {
    return new PipelineExtensionPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IPipelineExtension> extensions();

  interface FeatureIDs {
    int EXTENSIONS = -122558082;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IPipelineExtension, List<IPipelineExtension>, Listener<List<IPipelineExtension>>, Features<?>> EXTENSIONS = new RelationBuilder<IPipelineExtension, List<IPipelineExtension>, Listener<List<IPipelineExtension>>, Features<?>>().name("extensions").many(true).contains(true).id(PipelineExtensionPkg.FeatureIDs.EXTENSIONS).concept(() -> ProcessModelDefinition.Groups.I_PIPELINE_EXTENSION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSIONS);
  }

  interface Builder extends IFeaturedObject.Builder<PipelineExtensionPkg> {
    Builder addExtension(Supplier<IPipelineExtension> extension);
    Builder addExtensions(List<IPipelineExtension> extensions);
  }
}
