package org.sheepy.lily.openal.model.openal;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.resource.ResourcePkg;
import org.sheepy.lily.openal.model.openal.builder.OpenALEngineBuilder;

public interface OpenALEngine extends IEngine {
  static Builder builder() {
    return new OpenALEngineBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ResourcePkg resourcePkg();
  void resourcePkg(final ResourcePkg resourcePkg);

  interface FeatureIDs {
    int RESOURCE_PKG = -708621612;
  }

  interface Features<T extends Features<T>> extends IEngine.Features<T> {
    Relation<ResourcePkg, ResourcePkg, Listener<ResourcePkg>, Features<?>> RESOURCE_PKG = new RelationBuilder<ResourcePkg, ResourcePkg, Listener<ResourcePkg>, Features<?>>().name("resourcePkg").contains(true).id(OpenALEngine.FeatureIDs.RESOURCE_PKG).concept(() -> ResourceModelDefinition.Groups.RESOURCE_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCE_PKG);
  }

  interface Builder extends IFeaturedObject.Builder<OpenALEngine> {
    Builder resourcePkg(Supplier<ResourcePkg> resourcePkg);
  }
}
