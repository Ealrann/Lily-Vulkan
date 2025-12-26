package org.sheepy.lily.vulkan.extra.model.nuklear;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.joml.Vector4ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.PanelViewerBuilder;

public interface PanelViewer extends Panel {
  static Builder builder() {
    return new PanelViewerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  DirectVariableResolver variableResolver();
  void variableResolver(final DirectVariableResolver variableResolver);

  interface FeatureIDs {
    int WIDTH = ISizedElement.FeatureIDs.WIDTH;
    int HEIGHT = ISizedElement.FeatureIDs.HEIGHT;
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int NAME = Named.FeatureIDs.NAME;
    int CATCH_INPUTS = IPanel.FeatureIDs.CATCH_INPUTS;
    int REPORTING_HOVER = IPanel.FeatureIDs.REPORTING_HOVER;
    int CONTROLS = Panel.FeatureIDs.CONTROLS;
    int SHOW_TITLE = Panel.FeatureIDs.SHOW_TITLE;
    int MINIMIZABLE = Panel.FeatureIDs.MINIMIZABLE;
    int MOVABLE = Panel.FeatureIDs.MOVABLE;
    int MINIMIZED = Panel.FeatureIDs.MINIMIZED;
    int BACKGROUND_IMAGE = Panel.FeatureIDs.BACKGROUND_IMAGE;
    int BACKGROUND_COLOR = Panel.FeatureIDs.BACKGROUND_COLOR;
    int BORDER_COLOR = Panel.FeatureIDs.BORDER_COLOR;
    int VARIABLE_RESOLVER = 1588209062;
  }

  interface Features<T extends Features<T>> extends Panel.Features<T> {
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> WIDTH = ISizedElement.Features.WIDTH;
    Attribute<Integer, Integer, IntListener, ISizedElement.Features<?>> HEIGHT = ISizedElement.Features.HEIGHT;
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPanel.Features<?>> CATCH_INPUTS = IPanel.Features.CATCH_INPUTS;
    Attribute<Boolean, Boolean, BooleanListener, IPanel.Features<?>> REPORTING_HOVER = IPanel.Features.REPORTING_HOVER;
    Relation<IControl, List<IControl>, Listener<List<IControl>>, Panel.Features<?>> CONTROLS = Panel.Features.CONTROLS;
    Attribute<Boolean, Boolean, BooleanListener, Panel.Features<?>> SHOW_TITLE = Panel.Features.SHOW_TITLE;
    Attribute<Boolean, Boolean, BooleanListener, Panel.Features<?>> MINIMIZABLE = Panel.Features.MINIMIZABLE;
    Attribute<Boolean, Boolean, BooleanListener, Panel.Features<?>> MOVABLE = Panel.Features.MOVABLE;
    Attribute<Boolean, Boolean, BooleanListener, Panel.Features<?>> MINIMIZED = Panel.Features.MINIMIZED;
    Relation<IImage, IImage, Listener<IImage>, Panel.Features<?>> BACKGROUND_IMAGE = Panel.Features.BACKGROUND_IMAGE;
    Attribute<Vector4ic, Vector4ic, Listener<Vector4ic>, Panel.Features<?>> BACKGROUND_COLOR = Panel.Features.BACKGROUND_COLOR;
    Attribute<Vector4ic, Vector4ic, Listener<Vector4ic>, Panel.Features<?>> BORDER_COLOR = Panel.Features.BORDER_COLOR;
    Relation<DirectVariableResolver, DirectVariableResolver, Listener<DirectVariableResolver>, Features<?>> VARIABLE_RESOLVER = new RelationBuilder<DirectVariableResolver, DirectVariableResolver, Listener<DirectVariableResolver>, Features<?>>().name("variableResolver").mandatory(true).contains(true).id(PanelViewer.FeatureIDs.VARIABLE_RESOLVER).concept(() -> VariableModelDefinition.Groups.DIRECT_VARIABLE_RESOLVER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(WIDTH, HEIGHT, POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, NAME, CATCH_INPUTS, REPORTING_HOVER, CONTROLS, SHOW_TITLE, MINIMIZABLE, MOVABLE, MINIMIZED, BACKGROUND_IMAGE, BACKGROUND_COLOR, BORDER_COLOR, VARIABLE_RESOLVER);
  }

  interface Builder extends IFeaturedObject.Builder<PanelViewer> {
    Builder width(int width);
    Builder height(int height);
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder name(String name);
    Builder catchInputs(boolean catchInputs);
    Builder reportingHover(boolean reportingHover);
    Builder addControl(Supplier<IControl> control);
    Builder showTitle(boolean showTitle);
    Builder minimizable(boolean minimizable);
    Builder movable(boolean movable);
    Builder minimized(boolean minimized);
    Builder backgroundImage(Supplier<IImage> backgroundImage);
    Builder backgroundColor(Vector4ic backgroundColor);
    Builder borderColor(Vector4ic borderColor);
    Builder variableResolver(Supplier<DirectVariableResolver> variableResolver);
    Builder addControls(List<IControl> controls);
  }
}
