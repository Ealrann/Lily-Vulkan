package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.StructurePkgBuilder;

public interface StructurePkg extends LMObject {
  static Builder builder() {
    return new StructurePkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Structure> structures();

  interface FeatureIDs {
    int STRUCTURES = 1827575679;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Structure, List<Structure>, Listener<List<Structure>>, Features<?>> STRUCTURES = new RelationBuilder<Structure, List<Structure>, Listener<List<Structure>>, Features<?>>().name("structures").many(true).contains(true).id(StructurePkg.FeatureIDs.STRUCTURES).concept(() -> RenderingModelDefinition.Groups.STRUCTURE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(STRUCTURES);
  }

  interface Builder extends IFeaturedObject.Builder<StructurePkg> {
    Builder addStructure(Supplier<Structure> structure);
    Builder addStructures(List<Structure> structures);
  }
}
