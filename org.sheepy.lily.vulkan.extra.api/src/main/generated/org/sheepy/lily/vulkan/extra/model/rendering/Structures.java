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
import org.sheepy.lily.vulkan.extra.model.rendering.builder.StructuresBuilder;

public interface Structures extends LMObject {
  static Builder builder() {
    return new StructuresBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<StructurePkg> structurePkgs();

  interface FeatureIDs {
    int STRUCTURE_PKGS = 640335874;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<StructurePkg, List<StructurePkg>, Listener<List<StructurePkg>>, Features<?>> STRUCTURE_PKGS = new RelationBuilder<StructurePkg, List<StructurePkg>, Listener<List<StructurePkg>>, Features<?>>().name("structurePkgs").many(true).contains(true).id(Structures.FeatureIDs.STRUCTURE_PKGS).concept(() -> RenderingModelDefinition.Groups.STRUCTURE_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(STRUCTURE_PKGS);
  }

  interface Builder extends IFeaturedObject.Builder<Structures> {
    Builder addStructurePkg(Supplier<StructurePkg> structurePkg);
    Builder addStructurePkgs(List<StructurePkg> structurePkgs);
  }
}
