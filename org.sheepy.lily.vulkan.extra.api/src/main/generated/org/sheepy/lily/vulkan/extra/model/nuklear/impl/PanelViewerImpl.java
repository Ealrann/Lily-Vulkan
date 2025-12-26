package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import java.util.List;
import org.joml.Vector2ic;
import org.joml.Vector4ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearModelDefinition;
import org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer;

public final class PanelViewerImpl extends FeaturedObject<PanelViewer.Features<?>> implements PanelViewer {
  private static final int FEATURE_COUNT = 17;
  private final ModelNotifier<PanelViewer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int width;
  private int height;
  private Vector2ic position;
  private EVerticalRelative verticalRelative;
  private EHorizontalRelative horizontalRelative;
  private final String name;
  private boolean catchInputs;
  private boolean reportingHover;
  private final List<IControl> controls = newObservableList(Panel.FeatureIDs.CONTROLS, true, true);
  private boolean showTitle;
  private boolean minimizable;
  private boolean movable;
  private boolean minimized;
  private IImage backgroundImage;
  private Vector4ic backgroundColor;
  private Vector4ic borderColor;
  private DirectVariableResolver variableResolver;

  public PanelViewerImpl(final String name, final boolean catchInputs, final boolean reportingHover,
      final Vector4ic backgroundColor, final Vector4ic borderColor,
      final DirectVariableResolver variableResolver) {
    this.name = name;
    this.catchInputs = catchInputs;
    this.reportingHover = reportingHover;
    this.backgroundColor = backgroundColor;
    this.borderColor = borderColor;
    this.variableResolver = variableResolver;
    setContainer(variableResolver, PanelViewer.FeatureIDs.VARIABLE_RESOLVER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PanelViewer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int width() {
    return width;
  }

  @Override
  public void width(final int width) {
    final var oldValue = this.width;
    this.width = width;
    notifier.notifyInt(ISizedElement.FeatureIDs.WIDTH, false, false, oldValue, width);
  }

  @Override
  public int height() {
    return height;
  }

  @Override
  public void height(final int height) {
    final var oldValue = this.height;
    this.height = height;
    notifier.notifyInt(ISizedElement.FeatureIDs.HEIGHT, false, false, oldValue, height);
  }

  @Override
  public Vector2ic position() {
    return position;
  }

  @Override
  public void position(final Vector2ic position) {
    final var oldValue = this.position;
    this.position = position;
    notifier.notify(IPositionElement.FeatureIDs.POSITION, false, false, oldValue, position);
  }

  @Override
  public EVerticalRelative verticalRelative() {
    return verticalRelative;
  }

  @Override
  public void verticalRelative(final EVerticalRelative verticalRelative) {
    final var oldValue = this.verticalRelative;
    this.verticalRelative = verticalRelative;
    notifier.notify(IPositionElement.FeatureIDs.VERTICAL_RELATIVE, false, false, oldValue, verticalRelative);
  }

  @Override
  public EHorizontalRelative horizontalRelative() {
    return horizontalRelative;
  }

  @Override
  public void horizontalRelative(final EHorizontalRelative horizontalRelative) {
    final var oldValue = this.horizontalRelative;
    this.horizontalRelative = horizontalRelative;
    notifier.notify(IPositionElement.FeatureIDs.HORIZONTAL_RELATIVE, false, false, oldValue, horizontalRelative);
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean catchInputs() {
    return catchInputs;
  }

  @Override
  public void catchInputs(final boolean catchInputs) {
    final var oldValue = this.catchInputs;
    this.catchInputs = catchInputs;
    notifier.notifyBoolean(IPanel.FeatureIDs.CATCH_INPUTS, false, false, oldValue, catchInputs);
  }

  @Override
  public boolean reportingHover() {
    return reportingHover;
  }

  @Override
  public void reportingHover(final boolean reportingHover) {
    final var oldValue = this.reportingHover;
    this.reportingHover = reportingHover;
    notifier.notifyBoolean(IPanel.FeatureIDs.REPORTING_HOVER, false, false, oldValue, reportingHover);
  }

  @Override
  public List<IControl> controls() {
    return controls;
  }

  @Override
  public boolean showTitle() {
    return showTitle;
  }

  @Override
  public void showTitle(final boolean showTitle) {
    final var oldValue = this.showTitle;
    this.showTitle = showTitle;
    notifier.notifyBoolean(Panel.FeatureIDs.SHOW_TITLE, false, false, oldValue, showTitle);
  }

  @Override
  public boolean minimizable() {
    return minimizable;
  }

  @Override
  public void minimizable(final boolean minimizable) {
    final var oldValue = this.minimizable;
    this.minimizable = minimizable;
    notifier.notifyBoolean(Panel.FeatureIDs.MINIMIZABLE, false, false, oldValue, minimizable);
  }

  @Override
  public boolean movable() {
    return movable;
  }

  @Override
  public void movable(final boolean movable) {
    final var oldValue = this.movable;
    this.movable = movable;
    notifier.notifyBoolean(Panel.FeatureIDs.MOVABLE, false, false, oldValue, movable);
  }

  @Override
  public boolean minimized() {
    return minimized;
  }

  @Override
  public void minimized(final boolean minimized) {
    final var oldValue = this.minimized;
    this.minimized = minimized;
    notifier.notifyBoolean(Panel.FeatureIDs.MINIMIZED, false, false, oldValue, minimized);
  }

  @Override
  public IImage backgroundImage() {
    return backgroundImage;
  }

  @Override
  public void backgroundImage(final IImage backgroundImage) {
    final var oldValue = this.backgroundImage;
    final var eventType = backgroundImage == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.backgroundImage = backgroundImage;
    notifier.notify(Panel.FeatureIDs.BACKGROUND_IMAGE, false, false, eventType, oldValue, backgroundImage);
  }

  @Override
  public Vector4ic backgroundColor() {
    return backgroundColor;
  }

  @Override
  public void backgroundColor(final Vector4ic backgroundColor) {
    final var oldValue = this.backgroundColor;
    this.backgroundColor = backgroundColor;
    notifier.notify(Panel.FeatureIDs.BACKGROUND_COLOR, false, false, oldValue, backgroundColor);
  }

  @Override
  public Vector4ic borderColor() {
    return borderColor;
  }

  @Override
  public void borderColor(final Vector4ic borderColor) {
    final var oldValue = this.borderColor;
    this.borderColor = borderColor;
    notifier.notify(Panel.FeatureIDs.BORDER_COLOR, false, false, oldValue, borderColor);
  }

  @Override
  public DirectVariableResolver variableResolver() {
    return variableResolver;
  }

  @Override
  public void variableResolver(final DirectVariableResolver variableResolver) {
    final var oldValue = this.variableResolver;
    final var eventType = variableResolver == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.variableResolver = variableResolver;
    setContainer(variableResolver, PanelViewer.FeatureIDs.VARIABLE_RESOLVER);
    beforeContainmentNotify(eventType, oldValue, variableResolver);
    notifier.notify(PanelViewer.FeatureIDs.VARIABLE_RESOLVER, true, false, eventType, oldValue, variableResolver);
    afterContainmentNotify(eventType, oldValue, variableResolver);
  }

  @Override
  public Group<PanelViewer> lmGroup() {
    return NuklearModelDefinition.Groups.PANEL_VIEWER;
  }

  @Override
  protected FeatureSetter<PanelViewer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PanelViewer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PanelViewer.FeatureIDs.WIDTH -> 0;
      case PanelViewer.FeatureIDs.HEIGHT -> 1;
      case PanelViewer.FeatureIDs.POSITION -> 2;
      case PanelViewer.FeatureIDs.VERTICAL_RELATIVE -> 3;
      case PanelViewer.FeatureIDs.HORIZONTAL_RELATIVE -> 4;
      case PanelViewer.FeatureIDs.NAME -> 5;
      case PanelViewer.FeatureIDs.CATCH_INPUTS -> 6;
      case PanelViewer.FeatureIDs.REPORTING_HOVER -> 7;
      case PanelViewer.FeatureIDs.CONTROLS -> 8;
      case PanelViewer.FeatureIDs.SHOW_TITLE -> 9;
      case PanelViewer.FeatureIDs.MINIMIZABLE -> 10;
      case PanelViewer.FeatureIDs.MOVABLE -> 11;
      case PanelViewer.FeatureIDs.MINIMIZED -> 12;
      case PanelViewer.FeatureIDs.BACKGROUND_IMAGE -> 13;
      case PanelViewer.FeatureIDs.BACKGROUND_COLOR -> 14;
      case PanelViewer.FeatureIDs.BORDER_COLOR -> 15;
      case PanelViewer.FeatureIDs.VARIABLE_RESOLVER -> 16;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PanelViewer> GET_MAP = new FeatureGetter.Builder<PanelViewer>(FEATURE_COUNT, PanelViewerImpl::featureIndexStatic).add(PanelViewer.FeatureIDs.WIDTH, PanelViewer::width).add(PanelViewer.FeatureIDs.HEIGHT, PanelViewer::height).add(PanelViewer.FeatureIDs.POSITION, PanelViewer::position).add(PanelViewer.FeatureIDs.VERTICAL_RELATIVE, PanelViewer::verticalRelative).add(PanelViewer.FeatureIDs.HORIZONTAL_RELATIVE, PanelViewer::horizontalRelative).add(PanelViewer.FeatureIDs.NAME, PanelViewer::name).add(PanelViewer.FeatureIDs.CATCH_INPUTS, PanelViewer::catchInputs).add(PanelViewer.FeatureIDs.REPORTING_HOVER, PanelViewer::reportingHover).add(PanelViewer.FeatureIDs.CONTROLS, PanelViewer::controls).add(PanelViewer.FeatureIDs.SHOW_TITLE, PanelViewer::showTitle).add(PanelViewer.FeatureIDs.MINIMIZABLE, PanelViewer::minimizable).add(PanelViewer.FeatureIDs.MOVABLE, PanelViewer::movable).add(PanelViewer.FeatureIDs.MINIMIZED, PanelViewer::minimized).add(PanelViewer.FeatureIDs.BACKGROUND_IMAGE, PanelViewer::backgroundImage).add(PanelViewer.FeatureIDs.BACKGROUND_COLOR, PanelViewer::backgroundColor).add(PanelViewer.FeatureIDs.BORDER_COLOR, PanelViewer::borderColor).add(PanelViewer.FeatureIDs.VARIABLE_RESOLVER, PanelViewer::variableResolver).build();
    private static final FeatureSetter<PanelViewer> SET_MAP = new FeatureSetter.Builder<PanelViewer>(FEATURE_COUNT, PanelViewerImpl::featureIndexStatic).add(PanelViewer.FeatureIDs.WIDTH, (object, value) -> ((PanelViewerImpl) object).width((int) value)).add(PanelViewer.FeatureIDs.HEIGHT, (object, value) -> ((PanelViewerImpl) object).height((int) value)).add(PanelViewer.FeatureIDs.POSITION, (object, value) -> ((PanelViewerImpl) object).position((Vector2ic) value)).add(PanelViewer.FeatureIDs.VERTICAL_RELATIVE, (object, value) -> ((PanelViewerImpl) object).verticalRelative((EVerticalRelative) value)).add(PanelViewer.FeatureIDs.HORIZONTAL_RELATIVE, (object, value) -> ((PanelViewerImpl) object).horizontalRelative((EHorizontalRelative) value)).add(PanelViewer.FeatureIDs.CATCH_INPUTS, (object, value) -> ((PanelViewerImpl) object).catchInputs((boolean) value)).add(PanelViewer.FeatureIDs.REPORTING_HOVER, (object, value) -> ((PanelViewerImpl) object).reportingHover((boolean) value)).add(PanelViewer.FeatureIDs.SHOW_TITLE, (object, value) -> ((PanelViewerImpl) object).showTitle((boolean) value)).add(PanelViewer.FeatureIDs.MINIMIZABLE, (object, value) -> ((PanelViewerImpl) object).minimizable((boolean) value)).add(PanelViewer.FeatureIDs.MOVABLE, (object, value) -> ((PanelViewerImpl) object).movable((boolean) value)).add(PanelViewer.FeatureIDs.MINIMIZED, (object, value) -> ((PanelViewerImpl) object).minimized((boolean) value)).add(PanelViewer.FeatureIDs.BACKGROUND_IMAGE, (object, value) -> ((PanelViewerImpl) object).backgroundImage((IImage) value)).add(PanelViewer.FeatureIDs.BACKGROUND_COLOR, (object, value) -> ((PanelViewerImpl) object).backgroundColor((Vector4ic) value)).add(PanelViewer.FeatureIDs.BORDER_COLOR, (object, value) -> ((PanelViewerImpl) object).borderColor((Vector4ic) value)).add(PanelViewer.FeatureIDs.VARIABLE_RESOLVER, (object, value) -> ((PanelViewerImpl) object).variableResolver((DirectVariableResolver) value)).build();
  }
}
