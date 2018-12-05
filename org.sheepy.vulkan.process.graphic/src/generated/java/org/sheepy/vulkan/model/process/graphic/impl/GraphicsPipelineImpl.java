/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.sheepy.vulkan.model.process.graphic.ColorBlend;
import org.sheepy.vulkan.model.process.graphic.DynamicState;
import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.vulkan.model.process.graphic.IGraphicsPipeline;
import org.sheepy.vulkan.model.process.graphic.Rasterizer;
import org.sheepy.vulkan.model.process.graphic.ViewportState;

import org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl;

import org.sheepy.vulkan.model.resource.Shader;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getShaders <em>Shaders</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getViewportState <em>Viewport State</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getRasterizer <em>Rasterizer</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getColorBlend <em>Color Blend</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDynamicState <em>Dynamic State</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GraphicsPipelineImpl extends AbstractPipelineImpl implements GraphicsPipeline
{
	/**
	 * The cached value of the '{@link #getShaders() <em>Shaders</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaders()
	 * @generated
	 * @ordered
	 */
	protected EList<Shader> shaders;

	/**
	 * The cached value of the '{@link #getViewportState() <em>Viewport State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewportState()
	 * @generated
	 * @ordered
	 */
	protected ViewportState viewportState;

	/**
	 * The cached value of the '{@link #getRasterizer() <em>Rasterizer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRasterizer()
	 * @generated
	 * @ordered
	 */
	protected Rasterizer rasterizer;

	/**
	 * The cached value of the '{@link #getColorBlend() <em>Color Blend</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorBlend()
	 * @generated
	 * @ordered
	 */
	protected ColorBlend colorBlend;

	/**
	 * The cached value of the '{@link #getDynamicState() <em>Dynamic State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDynamicState()
	 * @generated
	 * @ordered
	 */
	protected DynamicState dynamicState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicsPipelineImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicPackage.Literals.GRAPHICS_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Shader> getShaders()
	{
		if (shaders == null)
		{
			shaders = new EObjectResolvingEList<Shader>(Shader.class, this, GraphicPackage.GRAPHICS_PIPELINE__SHADERS);
		}
		return shaders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewportState getViewportState()
	{
		return viewportState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetViewportState(ViewportState newViewportState, NotificationChain msgs)
	{
		ViewportState oldViewportState = viewportState;
		viewportState = newViewportState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, oldViewportState, newViewportState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewportState(ViewportState newViewportState)
	{
		if (newViewportState != viewportState)
		{
			NotificationChain msgs = null;
			if (viewportState != null)
				msgs = ((InternalEObject)viewportState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, null, msgs);
			if (newViewportState != null)
				msgs = ((InternalEObject)newViewportState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, null, msgs);
			msgs = basicSetViewportState(newViewportState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE, newViewportState, newViewportState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rasterizer getRasterizer()
	{
		return rasterizer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRasterizer(Rasterizer newRasterizer, NotificationChain msgs)
	{
		Rasterizer oldRasterizer = rasterizer;
		rasterizer = newRasterizer;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, oldRasterizer, newRasterizer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRasterizer(Rasterizer newRasterizer)
	{
		if (newRasterizer != rasterizer)
		{
			NotificationChain msgs = null;
			if (rasterizer != null)
				msgs = ((InternalEObject)rasterizer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, null, msgs);
			if (newRasterizer != null)
				msgs = ((InternalEObject)newRasterizer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, null, msgs);
			msgs = basicSetRasterizer(newRasterizer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER, newRasterizer, newRasterizer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorBlend getColorBlend()
	{
		return colorBlend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColorBlend(ColorBlend newColorBlend, NotificationChain msgs)
	{
		ColorBlend oldColorBlend = colorBlend;
		colorBlend = newColorBlend;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, oldColorBlend, newColorBlend);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColorBlend(ColorBlend newColorBlend)
	{
		if (newColorBlend != colorBlend)
		{
			NotificationChain msgs = null;
			if (colorBlend != null)
				msgs = ((InternalEObject)colorBlend).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, null, msgs);
			if (newColorBlend != null)
				msgs = ((InternalEObject)newColorBlend).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, null, msgs);
			msgs = basicSetColorBlend(newColorBlend, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND, newColorBlend, newColorBlend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicState getDynamicState()
	{
		return dynamicState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDynamicState(DynamicState newDynamicState, NotificationChain msgs)
	{
		DynamicState oldDynamicState = dynamicState;
		dynamicState = newDynamicState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, oldDynamicState, newDynamicState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDynamicState(DynamicState newDynamicState)
	{
		if (newDynamicState != dynamicState)
		{
			NotificationChain msgs = null;
			if (dynamicState != null)
				msgs = ((InternalEObject)dynamicState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, null, msgs);
			if (newDynamicState != null)
				msgs = ((InternalEObject)newDynamicState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, null, msgs);
			msgs = basicSetDynamicState(newDynamicState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE, newDynamicState, newDynamicState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				return basicSetViewportState(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				return basicSetRasterizer(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				return basicSetColorBlend(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				return basicSetDynamicState(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				return getShaders();
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				return getViewportState();
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				return getRasterizer();
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				return getColorBlend();
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				return getDynamicState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				getShaders().clear();
				getShaders().addAll((Collection<? extends Shader>)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				setViewportState((ViewportState)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				setRasterizer((Rasterizer)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				setColorBlend((ColorBlend)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				setDynamicState((DynamicState)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				getShaders().clear();
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				setViewportState((ViewportState)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				setRasterizer((Rasterizer)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				setColorBlend((ColorBlend)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				setDynamicState((DynamicState)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				return shaders != null && !shaders.isEmpty();
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				return viewportState != null;
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				return rasterizer != null;
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				return colorBlend != null;
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				return dynamicState != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == IGraphicsPipeline.class)
		{
			switch (derivedFeatureID)
			{
				case GraphicPackage.GRAPHICS_PIPELINE__SHADERS: return GraphicPackage.IGRAPHICS_PIPELINE__SHADERS;
				case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE: return GraphicPackage.IGRAPHICS_PIPELINE__VIEWPORT_STATE;
				case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER: return GraphicPackage.IGRAPHICS_PIPELINE__RASTERIZER;
				case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND: return GraphicPackage.IGRAPHICS_PIPELINE__COLOR_BLEND;
				case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE: return GraphicPackage.IGRAPHICS_PIPELINE__DYNAMIC_STATE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == IGraphicsPipeline.class)
		{
			switch (baseFeatureID)
			{
				case GraphicPackage.IGRAPHICS_PIPELINE__SHADERS: return GraphicPackage.GRAPHICS_PIPELINE__SHADERS;
				case GraphicPackage.IGRAPHICS_PIPELINE__VIEWPORT_STATE: return GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE;
				case GraphicPackage.IGRAPHICS_PIPELINE__RASTERIZER: return GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER;
				case GraphicPackage.IGRAPHICS_PIPELINE__COLOR_BLEND: return GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND;
				case GraphicPackage.IGRAPHICS_PIPELINE__DYNAMIC_STATE: return GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //GraphicsPipelineImpl
