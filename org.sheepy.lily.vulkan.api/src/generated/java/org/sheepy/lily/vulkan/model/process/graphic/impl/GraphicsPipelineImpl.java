/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;

import org.sheepy.lily.vulkan.model.process.impl.IVkPipelineImpl;
import org.sheepy.lily.vulkan.model.resource.Shader;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphics Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getMaintainer <em>Maintainer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getShaders <em>Shaders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getViewportState <em>Viewport State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getInputAssembly <em>Input Assembly</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getRasterizer <em>Rasterizer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getColorBlend <em>Color Blend</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getDynamicState <em>Dynamic State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#getVertexInputState <em>Vertex Input State</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl#isDepthStencil <em>Depth Stencil</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicsPipelineImpl extends IVkPipelineImpl implements GraphicsPipeline
{
	/**
	 * The cached value of the '{@link #getMaintainer() <em>Maintainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaintainer()
	 * @generated
	 * @ordered
	 */
	protected Maintainer<GraphicsPipeline> maintainer;

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
	 * The cached value of the '{@link #getInputAssembly() <em>Input Assembly</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputAssembly()
	 * @generated
	 * @ordered
	 */
	protected InputAssembly inputAssembly;

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
	 * The cached value of the '{@link #getVertexInputState() <em>Vertex Input State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexInputState()
	 * @generated
	 * @ordered
	 */
	protected VertexInputState vertexInputState;

	/**
	 * The default value of the '{@link #isDepthStencil() <em>Depth Stencil</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthStencil()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPTH_STENCIL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDepthStencil() <em>Depth Stencil</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthStencil()
	 * @generated
	 * @ordered
	 */
	protected boolean depthStencil = DEPTH_STENCIL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicsPipelineImpl()
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
	@SuppressWarnings("unchecked")
	@Override
	public Maintainer<GraphicsPipeline> getMaintainer()
	{
		if (maintainer != null && ((EObject)maintainer).eIsProxy())
		{
			InternalEObject oldMaintainer = (InternalEObject)maintainer;
			maintainer = (Maintainer<GraphicsPipeline>)eResolveProxy(oldMaintainer);
			if (maintainer != oldMaintainer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER, oldMaintainer, maintainer));
			}
		}
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Maintainer<GraphicsPipeline> basicGetMaintainer()
	{
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaintainer(Maintainer<GraphicsPipeline> newMaintainer, NotificationChain msgs)
	{
		Maintainer<GraphicsPipeline> oldMaintainer = maintainer;
		maintainer = newMaintainer;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER, oldMaintainer, newMaintainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaintainer(Maintainer<GraphicsPipeline> newMaintainer)
	{
		if (newMaintainer != maintainer)
		{
			NotificationChain msgs = null;
			if (maintainer != null)
				msgs = ((InternalEObject)maintainer).eInverseRemove(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			if (newMaintainer != null)
				msgs = ((InternalEObject)newMaintainer).eInverseAdd(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			msgs = basicSetMaintainer(newMaintainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER, newMaintainer, newMaintainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public InputAssembly getInputAssembly()
	{
		return inputAssembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputAssembly(InputAssembly newInputAssembly, NotificationChain msgs)
	{
		InputAssembly oldInputAssembly = inputAssembly;
		inputAssembly = newInputAssembly;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, oldInputAssembly, newInputAssembly);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputAssembly(InputAssembly newInputAssembly)
	{
		if (newInputAssembly != inputAssembly)
		{
			NotificationChain msgs = null;
			if (inputAssembly != null)
				msgs = ((InternalEObject)inputAssembly).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, null, msgs);
			if (newInputAssembly != null)
				msgs = ((InternalEObject)newInputAssembly).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, null, msgs);
			msgs = basicSetInputAssembly(newInputAssembly, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY, newInputAssembly, newInputAssembly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	public VertexInputState getVertexInputState()
	{
		return vertexInputState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertexInputState(VertexInputState newVertexInputState, NotificationChain msgs)
	{
		VertexInputState oldVertexInputState = vertexInputState;
		vertexInputState = newVertexInputState;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, oldVertexInputState, newVertexInputState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexInputState(VertexInputState newVertexInputState)
	{
		if (newVertexInputState != vertexInputState)
		{
			NotificationChain msgs = null;
			if (vertexInputState != null)
				msgs = ((InternalEObject)vertexInputState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, null, msgs);
			if (newVertexInputState != null)
				msgs = ((InternalEObject)newVertexInputState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, null, msgs);
			msgs = basicSetVertexInputState(newVertexInputState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE, newVertexInputState, newVertexInputState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDepthStencil()
	{
		return depthStencil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthStencil(boolean newDepthStencil)
	{
		boolean oldDepthStencil = depthStencil;
		depthStencil = newDepthStencil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.GRAPHICS_PIPELINE__DEPTH_STENCIL, oldDepthStencil, depthStencil));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				if (maintainer != null)
					msgs = ((InternalEObject)maintainer).eInverseRemove(this, MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
				return basicSetMaintainer((Maintainer<GraphicsPipeline>)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				return basicSetMaintainer(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				return basicSetViewportState(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
				return basicSetInputAssembly(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				return basicSetRasterizer(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				return basicSetColorBlend(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				return basicSetDynamicState(null, msgs);
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				return basicSetVertexInputState(null, msgs);
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
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				if (resolve) return getMaintainer();
				return basicGetMaintainer();
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				return getShaders();
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				return getViewportState();
			case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
				return getInputAssembly();
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				return getRasterizer();
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				return getColorBlend();
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				return getDynamicState();
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				return getVertexInputState();
			case GraphicPackage.GRAPHICS_PIPELINE__DEPTH_STENCIL:
				return isDepthStencil();
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
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				setMaintainer((Maintainer<GraphicsPipeline>)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				getShaders().clear();
				getShaders().addAll((Collection<? extends Shader>)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				setViewportState((ViewportState)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
				setInputAssembly((InputAssembly)newValue);
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
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				setVertexInputState((VertexInputState)newValue);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DEPTH_STENCIL:
				setDepthStencil((Boolean)newValue);
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
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				setMaintainer((Maintainer<GraphicsPipeline>)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				getShaders().clear();
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				setViewportState((ViewportState)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
				setInputAssembly((InputAssembly)null);
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
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				setVertexInputState((VertexInputState)null);
				return;
			case GraphicPackage.GRAPHICS_PIPELINE__DEPTH_STENCIL:
				setDepthStencil(DEPTH_STENCIL_EDEFAULT);
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
			case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER:
				return maintainer != null;
			case GraphicPackage.GRAPHICS_PIPELINE__SHADERS:
				return shaders != null && !shaders.isEmpty();
			case GraphicPackage.GRAPHICS_PIPELINE__VIEWPORT_STATE:
				return viewportState != null;
			case GraphicPackage.GRAPHICS_PIPELINE__INPUT_ASSEMBLY:
				return inputAssembly != null;
			case GraphicPackage.GRAPHICS_PIPELINE__RASTERIZER:
				return rasterizer != null;
			case GraphicPackage.GRAPHICS_PIPELINE__COLOR_BLEND:
				return colorBlend != null;
			case GraphicPackage.GRAPHICS_PIPELINE__DYNAMIC_STATE:
				return dynamicState != null;
			case GraphicPackage.GRAPHICS_PIPELINE__VERTEX_INPUT_STATE:
				return vertexInputState != null;
			case GraphicPackage.GRAPHICS_PIPELINE__DEPTH_STENCIL:
				return depthStencil != DEPTH_STENCIL_EDEFAULT;
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
		if (baseClass == Maintainable.class)
		{
			switch (derivedFeatureID)
			{
				case GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER: return MaintainerPackage.MAINTAINABLE__MAINTAINER;
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
		if (baseClass == Maintainable.class)
		{
			switch (baseFeatureID)
			{
				case MaintainerPackage.MAINTAINABLE__MAINTAINER: return GraphicPackage.GRAPHICS_PIPELINE__MAINTAINER;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (depthStencil: ");
		result.append(depthStencil);
		result.append(')');
		return result.toString();
	}

} //GraphicsPipelineImpl
