package org.sheepy.lily.vulkan.extra.model.nuklear.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.joml.Vector4ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer;
import org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer.Builder;
import org.sheepy.lily.vulkan.extra.model.nuklear.impl.PanelViewerImpl;

public final class PanelViewerBuilder implements Builder {
  private int width;
  private int height;
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private String name;
  private boolean catchInputs = true;
  private boolean reportingHover = true;
  private final List<Supplier<IControl>> controls = new ArrayList<>();
  private boolean showTitle = false;
  private boolean minimizable = false;
  private boolean movable = false;
  private boolean minimized = false;
  private Supplier<IImage> backgroundImage = () -> null;
  private Vector4ic backgroundColor = ((Function<String, Vector4ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==4){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);int w=Integer.parseInt(split[3]);return new org.joml.Vector4i(x,y,z,w);}}return new org.joml.Vector4i(0,0,0,0); }).apply("90;90;90;150");
  private Vector4ic borderColor = ((Function<String, Vector4ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==4){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);int z=Integer.parseInt(split[2]);int w=Integer.parseInt(split[3]);return new org.joml.Vector4i(x,y,z,w);}}return new org.joml.Vector4i(0,0,0,0); }).apply("60;60;60;150");
  private Supplier<DirectVariableResolver> variableResolver;

  public PanelViewerBuilder() {
  }

  @Override
  public PanelViewerBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public PanelViewerBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public PanelViewerBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public PanelViewerBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public PanelViewerBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public PanelViewerBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PanelViewerBuilder catchInputs(boolean catchInputs) {
    this.catchInputs = catchInputs;
    return this;
  }

  @Override
  public PanelViewerBuilder reportingHover(boolean reportingHover) {
    this.reportingHover = reportingHover;
    return this;
  }

  @Override
  public PanelViewerBuilder addControl(Supplier<IControl> control) {
    this.controls.add(control);
    return this;
  }

  @Override
  public PanelViewerBuilder addControls(final List<IControl> controls) {
    controls.forEach(value -> this.controls.add(() -> value));
    return this;
  }

  @Override
  public PanelViewerBuilder showTitle(boolean showTitle) {
    this.showTitle = showTitle;
    return this;
  }

  @Override
  public PanelViewerBuilder minimizable(boolean minimizable) {
    this.minimizable = minimizable;
    return this;
  }

  @Override
  public PanelViewerBuilder movable(boolean movable) {
    this.movable = movable;
    return this;
  }

  @Override
  public PanelViewerBuilder minimized(boolean minimized) {
    this.minimized = minimized;
    return this;
  }

  @Override
  public PanelViewerBuilder backgroundImage(Supplier<IImage> backgroundImage) {
    this.backgroundImage = backgroundImage;
    return this;
  }

  @Override
  public PanelViewerBuilder backgroundColor(Vector4ic backgroundColor) {
    this.backgroundColor = backgroundColor;
    return this;
  }

  @Override
  public PanelViewerBuilder borderColor(Vector4ic borderColor) {
    this.borderColor = borderColor;
    return this;
  }

  @Override
  public PanelViewerBuilder variableResolver(Supplier<DirectVariableResolver> variableResolver) {
    this.variableResolver = variableResolver;
    return this;
  }

  @Override
  public PanelViewer build() {
    final var builtControls = BuildUtils.collectSuppliers(controls);
    final var built = new PanelViewerImpl(name, catchInputs, reportingHover, backgroundColor, borderColor, variableResolver.get());
    built.width(width);
    built.height(height);
    built.position(position);
    built.verticalRelative(verticalRelative);
    built.horizontalRelative(horizontalRelative);
    built.controls().addAll(builtControls);
    built.showTitle(showTitle);
    built.minimizable(minimizable);
    built.movable(movable);
    built.minimized(minimized);
    built.backgroundImage(backgroundImage.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<PanelViewerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PanelViewerBuilder>(14, Inserters::attributeIndex).add(PanelViewer.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(PanelViewer.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(PanelViewer.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(PanelViewer.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).add(PanelViewer.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(PanelViewer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(PanelViewer.FeatureIDs.CATCH_INPUTS, (builder, value) -> builder.catchInputs((boolean) value)).add(PanelViewer.FeatureIDs.REPORTING_HOVER, (builder, value) -> builder.reportingHover((boolean) value)).add(PanelViewer.FeatureIDs.SHOW_TITLE, (builder, value) -> builder.showTitle((boolean) value)).add(PanelViewer.FeatureIDs.MINIMIZABLE, (builder, value) -> builder.minimizable((boolean) value)).add(PanelViewer.FeatureIDs.MOVABLE, (builder, value) -> builder.movable((boolean) value)).add(PanelViewer.FeatureIDs.MINIMIZED, (builder, value) -> builder.minimized((boolean) value)).add(PanelViewer.FeatureIDs.BACKGROUND_COLOR, (builder, value) -> builder.backgroundColor((Vector4ic) value)).add(PanelViewer.FeatureIDs.BORDER_COLOR, (builder, value) -> builder.borderColor((Vector4ic) value)).build();
    private static final RelationLazyInserter<PanelViewerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PanelViewerBuilder>(3, Inserters::relationIndex).add(PanelViewer.FeatureIDs.CONTROLS, (builder, value) -> builder.addControl((Supplier<IControl>) value)).add(PanelViewer.FeatureIDs.BACKGROUND_IMAGE, (builder, value) -> builder.backgroundImage((Supplier<IImage>) value)).add(PanelViewer.FeatureIDs.VARIABLE_RESOLVER, (builder, value) -> builder.variableResolver((Supplier<DirectVariableResolver>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case PanelViewer.FeatureIDs.WIDTH -> 0;
        case PanelViewer.FeatureIDs.HEIGHT -> 1;
        case PanelViewer.FeatureIDs.POSITION -> 2;
        case PanelViewer.FeatureIDs.VERTICAL_RELATIVE -> 3;
        case PanelViewer.FeatureIDs.HORIZONTAL_RELATIVE -> 4;
        case PanelViewer.FeatureIDs.NAME -> 5;
        case PanelViewer.FeatureIDs.CATCH_INPUTS -> 6;
        case PanelViewer.FeatureIDs.REPORTING_HOVER -> 7;
        case PanelViewer.FeatureIDs.SHOW_TITLE -> 8;
        case PanelViewer.FeatureIDs.MINIMIZABLE -> 9;
        case PanelViewer.FeatureIDs.MOVABLE -> 10;
        case PanelViewer.FeatureIDs.MINIMIZED -> 11;
        case PanelViewer.FeatureIDs.BACKGROUND_COLOR -> 12;
        case PanelViewer.FeatureIDs.BORDER_COLOR -> 13;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PanelViewer.FeatureIDs.CONTROLS -> 0;
        case PanelViewer.FeatureIDs.BACKGROUND_IMAGE -> 1;
        case PanelViewer.FeatureIDs.VARIABLE_RESOLVER -> 2;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
