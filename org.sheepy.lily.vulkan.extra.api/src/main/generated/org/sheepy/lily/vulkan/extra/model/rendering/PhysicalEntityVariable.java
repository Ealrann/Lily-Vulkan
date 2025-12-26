package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.PhysicalEntityVariableBuilder;

public interface PhysicalEntityVariable extends IModelVariable {
  static Builder builder() {
    return new PhysicalEntityVariableBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  PhysicalEntity entity();
  EPhysicalEntityFeature feature();
  void entity(final PhysicalEntity entity);
  void feature(final EPhysicalEntityFeature feature);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENTITY = -1010105211;
    int FEATURE = -635867500;
  }

  interface Features<T extends Features<T>> extends IModelVariable.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<PhysicalEntity, PhysicalEntity, Listener<PhysicalEntity>, Features<?>> ENTITY = new RelationBuilder<PhysicalEntity, PhysicalEntity, Listener<PhysicalEntity>, Features<?>>().name("entity").id(PhysicalEntityVariable.FeatureIDs.ENTITY).concept(() -> RenderingModelDefinition.Groups.PHYSICAL_ENTITY).build();
    Attribute<EPhysicalEntityFeature, EPhysicalEntityFeature, Listener<EPhysicalEntityFeature>, Features<?>> FEATURE = new AttributeBuilder<EPhysicalEntityFeature, EPhysicalEntityFeature, Listener<EPhysicalEntityFeature>, Features<?>>().name("feature").mandatory(true).id(PhysicalEntityVariable.FeatureIDs.FEATURE).datatype(() -> RenderingModelDefinition.Enums.E_PHYSICAL_ENTITY_FEATURE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENTITY, FEATURE);
  }

  interface Builder extends IFeaturedObject.Builder<PhysicalEntityVariable> {
    Builder name(String name);
    Builder entity(Supplier<PhysicalEntity> entity);
    Builder feature(EPhysicalEntityFeature feature);
  }
}
