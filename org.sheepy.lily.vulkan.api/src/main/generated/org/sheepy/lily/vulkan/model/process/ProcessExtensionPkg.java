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
import org.sheepy.lily.vulkan.model.process.builder.ProcessExtensionPkgBuilder;

public interface ProcessExtensionPkg extends LMObject {
  static Builder builder() {
    return new ProcessExtensionPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IProcessExtension> extensions();

  interface FeatureIDs {
    int EXTENSIONS = 1220674419;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IProcessExtension, List<IProcessExtension>, Listener<List<IProcessExtension>>, Features<?>> EXTENSIONS = new RelationBuilder<IProcessExtension, List<IProcessExtension>, Listener<List<IProcessExtension>>, Features<?>>().name("extensions").many(true).contains(true).id(ProcessExtensionPkg.FeatureIDs.EXTENSIONS).concept(() -> ProcessModelDefinition.Groups.I_PROCESS_EXTENSION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTENSIONS);
  }

  interface Builder extends IFeaturedObject.Builder<ProcessExtensionPkg> {
    Builder addExtension(Supplier<IProcessExtension> extension);
    Builder addExtensions(List<IProcessExtension> extensions);
  }
}
