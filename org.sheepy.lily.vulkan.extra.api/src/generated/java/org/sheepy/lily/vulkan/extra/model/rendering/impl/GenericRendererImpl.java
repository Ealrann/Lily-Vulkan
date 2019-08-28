/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceProvider;

import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl;

import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Renderer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl#getMaintained <em>Maintained</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl#getDataProviderPkg <em>Data Provider Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl#getRenderedStructures <em>Rendered Structures</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl#getConstantBuffer <em>Constant Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl#getPushBuffer <em>Push Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererImpl#getCommonResourceProvider <em>Common Resource Provider</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenericRendererImpl<T extends Structure> extends GraphicsPipelineImpl implements GenericRenderer<T>
{
	/**
	 * The cached value of the '{@link #getMaintained() <em>Maintained</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaintained()
	 * @generated
	 * @ordered
	 */
	protected EList<Maintainable<GraphicsPipeline>> maintained;

	/**
	 * The cached value of the '{@link #getDataProviderPkg() <em>Data Provider Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProviderPkg()
	 * @generated
	 * @ordered
	 */
	protected DataProviderPkg<T> dataProviderPkg;

	/**
	 * The cached value of the '{@link #getRenderedStructures() <em>Rendered Structures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenderedStructures()
	 * @generated
	 * @ordered
	 */
	protected EList<T> renderedStructures;

	/**
	 * The cached value of the '{@link #getConstantBuffer() <em>Constant Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantBuffer()
	 * @generated
	 * @ordered
	 */
	protected ConstantBuffer constantBuffer;

	/**
	 * The cached value of the '{@link #getPushBuffer() <em>Push Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPushBuffer()
	 * @generated
	 * @ordered
	 */
	protected PushBuffer pushBuffer;

	/**
	 * The cached value of the '{@link #getCommonResourceProvider() <em>Common Resource Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommonResourceProvider()
	 * @generated
	 * @ordered
	 */
	protected ResourceProvider commonResourceProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericRendererImpl()
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
		return RenderingPackage.Literals.GENERIC_RENDERER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Maintainable<GraphicsPipeline>> getMaintained()
	{
		if (maintained == null)
		{
			maintained = new EObjectWithInverseResolvingEList<Maintainable<GraphicsPipeline>>(Maintainable.class, this, RenderingPackage.GENERIC_RENDERER__MAINTAINED, MaintainerPackage.MAINTAINABLE__MAINTAINER);
		}
		return maintained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataProviderPkg<T> getDataProviderPkg()
	{
		return dataProviderPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataProviderPkg(DataProviderPkg<T> newDataProviderPkg, NotificationChain msgs)
	{
		DataProviderPkg<T> oldDataProviderPkg = dataProviderPkg;
		dataProviderPkg = newDataProviderPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG, oldDataProviderPkg, newDataProviderPkg);
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
	public void setDataProviderPkg(DataProviderPkg<T> newDataProviderPkg)
	{
		if (newDataProviderPkg != dataProviderPkg)
		{
			NotificationChain msgs = null;
			if (dataProviderPkg != null)
				msgs = ((InternalEObject)dataProviderPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG, null, msgs);
			if (newDataProviderPkg != null)
				msgs = ((InternalEObject)newDataProviderPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG, null, msgs);
			msgs = basicSetDataProviderPkg(newDataProviderPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG, newDataProviderPkg, newDataProviderPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<T> getRenderedStructures()
	{
		if (renderedStructures == null)
		{
			renderedStructures = new EObjectResolvingEList<T>(Structure.class, this, RenderingPackage.GENERIC_RENDERER__RENDERED_STRUCTURES);
		}
		return renderedStructures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantBuffer getConstantBuffer()
	{
		if (constantBuffer != null && ((EObject)constantBuffer).eIsProxy())
		{
			InternalEObject oldConstantBuffer = (InternalEObject)constantBuffer;
			constantBuffer = (ConstantBuffer)eResolveProxy(oldConstantBuffer);
			if (constantBuffer != oldConstantBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER, oldConstantBuffer, constantBuffer));
			}
		}
		return constantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantBuffer basicGetConstantBuffer()
	{
		return constantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantBuffer(ConstantBuffer newConstantBuffer)
	{
		ConstantBuffer oldConstantBuffer = constantBuffer;
		constantBuffer = newConstantBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER, oldConstantBuffer, constantBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PushBuffer getPushBuffer()
	{
		if (pushBuffer != null && ((EObject)pushBuffer).eIsProxy())
		{
			InternalEObject oldPushBuffer = (InternalEObject)pushBuffer;
			pushBuffer = (PushBuffer)eResolveProxy(oldPushBuffer);
			if (pushBuffer != oldPushBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.GENERIC_RENDERER__PUSH_BUFFER, oldPushBuffer, pushBuffer));
			}
		}
		return pushBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PushBuffer basicGetPushBuffer()
	{
		return pushBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPushBuffer(PushBuffer newPushBuffer)
	{
		PushBuffer oldPushBuffer = pushBuffer;
		pushBuffer = newPushBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER__PUSH_BUFFER, oldPushBuffer, pushBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceProvider getCommonResourceProvider()
	{
		return commonResourceProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCommonResourceProvider(ResourceProvider newCommonResourceProvider, NotificationChain msgs)
	{
		ResourceProvider oldCommonResourceProvider = commonResourceProvider;
		commonResourceProvider = newCommonResourceProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER, oldCommonResourceProvider, newCommonResourceProvider);
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
	public void setCommonResourceProvider(ResourceProvider newCommonResourceProvider)
	{
		if (newCommonResourceProvider != commonResourceProvider)
		{
			NotificationChain msgs = null;
			if (commonResourceProvider != null)
				msgs = ((InternalEObject)commonResourceProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER, null, msgs);
			if (newCommonResourceProvider != null)
				msgs = ((InternalEObject)newCommonResourceProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER, null, msgs);
			msgs = basicSetCommonResourceProvider(newCommonResourceProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER, newCommonResourceProvider, newCommonResourceProvider));
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
			case RenderingPackage.GENERIC_RENDERER__MAINTAINED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMaintained()).basicAdd(otherEnd, msgs);
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
			case RenderingPackage.GENERIC_RENDERER__MAINTAINED:
				return ((InternalEList<?>)getMaintained()).basicRemove(otherEnd, msgs);
			case RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG:
				return basicSetDataProviderPkg(null, msgs);
			case RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER:
				return basicSetCommonResourceProvider(null, msgs);
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
			case RenderingPackage.GENERIC_RENDERER__MAINTAINED:
				return getMaintained();
			case RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG:
				return getDataProviderPkg();
			case RenderingPackage.GENERIC_RENDERER__RENDERED_STRUCTURES:
				return getRenderedStructures();
			case RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER:
				if (resolve) return getConstantBuffer();
				return basicGetConstantBuffer();
			case RenderingPackage.GENERIC_RENDERER__PUSH_BUFFER:
				if (resolve) return getPushBuffer();
				return basicGetPushBuffer();
			case RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER:
				return getCommonResourceProvider();
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
			case RenderingPackage.GENERIC_RENDERER__MAINTAINED:
				getMaintained().clear();
				getMaintained().addAll((Collection<? extends Maintainable<GraphicsPipeline>>)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG:
				setDataProviderPkg((DataProviderPkg<T>)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER__RENDERED_STRUCTURES:
				getRenderedStructures().clear();
				getRenderedStructures().addAll((Collection<? extends T>)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER:
				setConstantBuffer((ConstantBuffer)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER__PUSH_BUFFER:
				setPushBuffer((PushBuffer)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER:
				setCommonResourceProvider((ResourceProvider)newValue);
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
			case RenderingPackage.GENERIC_RENDERER__MAINTAINED:
				getMaintained().clear();
				return;
			case RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG:
				setDataProviderPkg((DataProviderPkg<T>)null);
				return;
			case RenderingPackage.GENERIC_RENDERER__RENDERED_STRUCTURES:
				getRenderedStructures().clear();
				return;
			case RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER:
				setConstantBuffer((ConstantBuffer)null);
				return;
			case RenderingPackage.GENERIC_RENDERER__PUSH_BUFFER:
				setPushBuffer((PushBuffer)null);
				return;
			case RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER:
				setCommonResourceProvider((ResourceProvider)null);
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
			case RenderingPackage.GENERIC_RENDERER__MAINTAINED:
				return maintained != null && !maintained.isEmpty();
			case RenderingPackage.GENERIC_RENDERER__DATA_PROVIDER_PKG:
				return dataProviderPkg != null;
			case RenderingPackage.GENERIC_RENDERER__RENDERED_STRUCTURES:
				return renderedStructures != null && !renderedStructures.isEmpty();
			case RenderingPackage.GENERIC_RENDERER__CONSTANT_BUFFER:
				return constantBuffer != null;
			case RenderingPackage.GENERIC_RENDERER__PUSH_BUFFER:
				return pushBuffer != null;
			case RenderingPackage.GENERIC_RENDERER__COMMON_RESOURCE_PROVIDER:
				return commonResourceProvider != null;
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
		if (baseClass == Maintainer.class)
		{
			switch (derivedFeatureID)
			{
				case RenderingPackage.GENERIC_RENDERER__MAINTAINED: return MaintainerPackage.MAINTAINER__MAINTAINED;
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
		if (baseClass == Maintainer.class)
		{
			switch (baseFeatureID)
			{
				case MaintainerPackage.MAINTAINER__MAINTAINED: return RenderingPackage.GENERIC_RENDERER__MAINTAINED;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //GenericRendererImpl
