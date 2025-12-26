package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.SelectionProxyBuilder;

public interface SelectionProxy extends LMObject {
  static Builder builder() {
    return new SelectionProxyBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EMousePickMode pickMode();
  IEntitySelection selection();
  IEntitySelection focus();
  void pickMode(final EMousePickMode pickMode);
  void selection(final IEntitySelection selection);
  void focus(final IEntitySelection focus);

  interface FeatureIDs {
    int PICK_MODE = 722415866;
    int SELECTION = 657647798;
    int FOCUS = 648671490;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EMousePickMode, EMousePickMode, Listener<EMousePickMode>, Features<?>> PICK_MODE = new AttributeBuilder<EMousePickMode, EMousePickMode, Listener<EMousePickMode>, Features<?>>().name("pickMode").mandatory(true).defaultValue("Enabled").id(SelectionProxy.FeatureIDs.PICK_MODE).datatype(() -> RenderingModelDefinition.Enums.E_MOUSE_PICK_MODE).build();
    Relation<IEntitySelection, IEntitySelection, Listener<IEntitySelection>, Features<?>> SELECTION = new RelationBuilder<IEntitySelection, IEntitySelection, Listener<IEntitySelection>, Features<?>>().name("selection").contains(true).id(SelectionProxy.FeatureIDs.SELECTION).concept(() -> RenderingModelDefinition.Groups.I_ENTITY_SELECTION).build();
    Relation<IEntitySelection, IEntitySelection, Listener<IEntitySelection>, Features<?>> FOCUS = new RelationBuilder<IEntitySelection, IEntitySelection, Listener<IEntitySelection>, Features<?>>().name("focus").contains(true).id(SelectionProxy.FeatureIDs.FOCUS).concept(() -> RenderingModelDefinition.Groups.I_ENTITY_SELECTION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PICK_MODE, SELECTION, FOCUS);
  }

  interface Builder extends IFeaturedObject.Builder<SelectionProxy> {
    Builder pickMode(EMousePickMode pickMode);
    Builder selection(Supplier<IEntitySelection> selection);
    Builder focus(Supplier<IEntitySelection> focus);
  }
}
