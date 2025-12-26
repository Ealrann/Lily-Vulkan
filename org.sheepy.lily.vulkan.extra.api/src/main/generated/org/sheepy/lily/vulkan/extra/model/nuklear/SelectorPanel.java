package org.sheepy.lily.vulkan.extra.model.nuklear;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
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
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.SelectorPanelBuilder;

public interface SelectorPanel extends IPanel {
  static Builder builder() {
    return new SelectorPanelBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int buttonSizePx();
  int selectionR();
  int selectionG();
  int selectionB();
  boolean printLabels();
  DirectVariableResolver variableResolver();
  IInputProvider inputProvider();
  boolean vertical();
  boolean autoHideLabels();
  int fadeOutMs();
  boolean unsettable();
  boolean detectHoverOnLabels();
  void buttonSizePx(final int buttonSizePx);
  void selectionR(final int selectionR);
  void selectionG(final int selectionG);
  void selectionB(final int selectionB);
  void printLabels(final boolean printLabels);
  void variableResolver(final DirectVariableResolver variableResolver);
  void inputProvider(final IInputProvider inputProvider);
  void vertical(final boolean vertical);
  void autoHideLabels(final boolean autoHideLabels);
  void fadeOutMs(final int fadeOutMs);
  void unsettable(final boolean unsettable);
  void detectHoverOnLabels(final boolean detectHoverOnLabels);

  interface FeatureIDs {
    int POSITION = IPositionElement.FeatureIDs.POSITION;
    int VERTICAL_RELATIVE = IPositionElement.FeatureIDs.VERTICAL_RELATIVE;
    int HORIZONTAL_RELATIVE = IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE;
    int NAME = Named.FeatureIDs.NAME;
    int CATCH_INPUTS = IPanel.FeatureIDs.CATCH_INPUTS;
    int REPORTING_HOVER = IPanel.FeatureIDs.REPORTING_HOVER;
    int BUTTON_SIZE_PX = -2102201104;
    int SELECTIONR = -1367987525;
    int SELECTIONG = -1367987536;
    int SELECTIONB = -1367987541;
    int PRINT_LABELS = -234197705;
    int VARIABLE_RESOLVER = 270316887;
    int INPUT_PROVIDER = -285811386;
    int VERTICAL = -1116804309;
    int AUTO_HIDE_LABELS = 2123989733;
    int FADE_OUT_MS = 218953571;
    int UNSETTABLE = -1047020358;
    int DETECT_HOVER_ON_LABELS = -1918887070;
  }

  interface Features<T extends Features<T>> extends IPanel.Features<T> {
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, IPositionElement.Features<?>> POSITION = IPositionElement.Features.POSITION;
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, IPositionElement.Features<?>> VERTICAL_RELATIVE = IPositionElement.Features.VERTICAL_RELATIVE;
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, IPositionElement.Features<?>> HORIZONTAL_RELATIVE = IPositionElement.Features.HORIZONTAL_RELATIVE;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPanel.Features<?>> CATCH_INPUTS = IPanel.Features.CATCH_INPUTS;
    Attribute<Boolean, Boolean, BooleanListener, IPanel.Features<?>> REPORTING_HOVER = IPanel.Features.REPORTING_HOVER;
    Attribute<Integer, Integer, IntListener, Features<?>> BUTTON_SIZE_PX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("buttonSizePx").mandatory(true).defaultValue("32").id(SelectorPanel.FeatureIDs.BUTTON_SIZE_PX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> SELECTIONR = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("selectionR").mandatory(true).defaultValue("0").id(SelectorPanel.FeatureIDs.SELECTIONR).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> SELECTIONG = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("selectionG").mandatory(true).defaultValue("135").id(SelectorPanel.FeatureIDs.SELECTIONG).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> SELECTIONB = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("selectionB").mandatory(true).defaultValue("255").id(SelectorPanel.FeatureIDs.SELECTIONB).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> PRINT_LABELS = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("printLabels").mandatory(true).id(SelectorPanel.FeatureIDs.PRINT_LABELS).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Relation<DirectVariableResolver, DirectVariableResolver, Listener<DirectVariableResolver>, Features<?>> VARIABLE_RESOLVER = new RelationBuilder<DirectVariableResolver, DirectVariableResolver, Listener<DirectVariableResolver>, Features<?>>().name("variableResolver").mandatory(true).contains(true).id(SelectorPanel.FeatureIDs.VARIABLE_RESOLVER).concept(() -> VariableModelDefinition.Groups.DIRECT_VARIABLE_RESOLVER).build();
    Relation<IInputProvider, IInputProvider, Listener<IInputProvider>, Features<?>> INPUT_PROVIDER = new RelationBuilder<IInputProvider, IInputProvider, Listener<IInputProvider>, Features<?>>().name("inputProvider").mandatory(true).contains(true).id(SelectorPanel.FeatureIDs.INPUT_PROVIDER).concept(() -> NuklearModelDefinition.Groups.I_INPUT_PROVIDER).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> VERTICAL = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("vertical").mandatory(true).defaultValue("true").id(SelectorPanel.FeatureIDs.VERTICAL).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> AUTO_HIDE_LABELS = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("autoHideLabels").mandatory(true).defaultValue("true").id(SelectorPanel.FeatureIDs.AUTO_HIDE_LABELS).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Integer, Integer, IntListener, Features<?>> FADE_OUT_MS = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("fadeOutMs").mandatory(true).defaultValue("500").id(SelectorPanel.FeatureIDs.FADE_OUT_MS).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> UNSETTABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("unsettable").mandatory(true).defaultValue("false").id(SelectorPanel.FeatureIDs.UNSETTABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> DETECT_HOVER_ON_LABELS = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("detectHoverOnLabels").mandatory(true).defaultValue("false").id(SelectorPanel.FeatureIDs.DETECT_HOVER_ON_LABELS).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(POSITION, VERTICAL_RELATIVE, HORIZONTAL_RELATIVE, NAME, CATCH_INPUTS, REPORTING_HOVER, BUTTON_SIZE_PX, SELECTIONR, SELECTIONG, SELECTIONB, PRINT_LABELS, VARIABLE_RESOLVER, INPUT_PROVIDER, VERTICAL, AUTO_HIDE_LABELS, FADE_OUT_MS, UNSETTABLE, DETECT_HOVER_ON_LABELS);
  }

  interface Builder extends IFeaturedObject.Builder<SelectorPanel> {
    Builder position(Vector2ic position);
    Builder verticalRelative(EVerticalRelative verticalRelative);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder name(String name);
    Builder catchInputs(boolean catchInputs);
    Builder reportingHover(boolean reportingHover);
    Builder buttonSizePx(int buttonSizePx);
    Builder selectionR(int selectionR);
    Builder selectionG(int selectionG);
    Builder selectionB(int selectionB);
    Builder printLabels(boolean printLabels);
    Builder variableResolver(Supplier<DirectVariableResolver> variableResolver);
    Builder inputProvider(Supplier<IInputProvider> inputProvider);
    Builder vertical(boolean vertical);
    Builder autoHideLabels(boolean autoHideLabels);
    Builder fadeOutMs(int fadeOutMs);
    Builder unsettable(boolean unsettable);
    Builder detectHoverOnLabels(boolean detectHoverOnLabels);
  }
}
