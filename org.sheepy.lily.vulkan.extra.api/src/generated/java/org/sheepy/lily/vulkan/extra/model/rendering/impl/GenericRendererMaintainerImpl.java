/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.vulkan.extra.model.rendering.GenericDataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRendererMaintainer;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.PushBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Renderer Maintainer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl#getMaintained <em>Maintained</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl#getDataProviders <em>Data Providers</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl#getPresentationPkg <em>Presentation Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl#getConstantBuffer <em>Constant Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl#getBasicResources <em>Basic Resources</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl#getPushBuffer <em>Push Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenericRendererMaintainerImpl<T extends Presentation> extends GraphicsPipelineImpl implements GenericRendererMaintainer<T>
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
	 * The cached value of the '{@link #getDataProviders() <em>Data Providers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProviders()
	 * @generated
	 * @ordered
	 */
	protected EList<GenericDataProvider<T>> dataProviders;

	/**
	 * The cached value of the '{@link #getPresentationPkg() <em>Presentation Pkg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationPkg()
	 * @generated
	 * @ordered
	 */
	protected PresentationPkg presentationPkg;

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
	 * The cached value of the '{@link #getBasicResources() <em>Basic Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicResources()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptedResource> basicResources;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericRendererMaintainerImpl()
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
		return RenderingPackage.Literals.GENERIC_RENDERER_MAINTAINER;
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
			maintained = new EObjectWithInverseResolvingEList<Maintainable<GraphicsPipeline>>(Maintainable.class, this, RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED, MaintainerPackage.MAINTAINABLE__MAINTAINER);
		}
		return maintained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GenericDataProvider<T>> getDataProviders()
	{
		if (dataProviders == null)
		{
			dataProviders = new EObjectContainmentEList<GenericDataProvider<T>>(GenericDataProvider.class, this, RenderingPackage.GENERIC_RENDERER_MAINTAINER__DATA_PROVIDERS);
		}
		return dataProviders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PresentationPkg getPresentationPkg()
	{
		if (presentationPkg != null && presentationPkg.eIsProxy())
		{
			InternalEObject oldPresentationPkg = (InternalEObject)presentationPkg;
			presentationPkg = (PresentationPkg)eResolveProxy(oldPresentationPkg);
			if (presentationPkg != oldPresentationPkg)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG, oldPresentationPkg, presentationPkg));
			}
		}
		return presentationPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationPkg basicGetPresentationPkg()
	{
		return presentationPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPresentationPkg(PresentationPkg newPresentationPkg)
	{
		PresentationPkg oldPresentationPkg = presentationPkg;
		presentationPkg = newPresentationPkg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG, oldPresentationPkg, presentationPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantBuffer getConstantBuffer()
	{
		if (constantBuffer != null && constantBuffer.eIsProxy())
		{
			InternalEObject oldConstantBuffer = (InternalEObject)constantBuffer;
			constantBuffer = (ConstantBuffer)eResolveProxy(oldConstantBuffer);
			if (constantBuffer != oldConstantBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER, oldConstantBuffer, constantBuffer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER, oldConstantBuffer, constantBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptedResource> getBasicResources()
	{
		if (basicResources == null)
		{
			basicResources = new EObjectResolvingEList<DescriptedResource>(DescriptedResource.class, this, RenderingPackage.GENERIC_RENDERER_MAINTAINER__BASIC_RESOURCES);
		}
		return basicResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PushBuffer getPushBuffer()
	{
		if (pushBuffer != null && pushBuffer.eIsProxy())
		{
			InternalEObject oldPushBuffer = (InternalEObject)pushBuffer;
			pushBuffer = (PushBuffer)eResolveProxy(oldPushBuffer);
			if (pushBuffer != oldPushBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER, oldPushBuffer, pushBuffer));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER, oldPushBuffer, pushBuffer));
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
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED:
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
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED:
				return ((InternalEList<?>)getMaintained()).basicRemove(otherEnd, msgs);
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__DATA_PROVIDERS:
				return ((InternalEList<?>)getDataProviders()).basicRemove(otherEnd, msgs);
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
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED:
				return getMaintained();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__DATA_PROVIDERS:
				return getDataProviders();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG:
				if (resolve) return getPresentationPkg();
				return basicGetPresentationPkg();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER:
				if (resolve) return getConstantBuffer();
				return basicGetConstantBuffer();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__BASIC_RESOURCES:
				return getBasicResources();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER:
				if (resolve) return getPushBuffer();
				return basicGetPushBuffer();
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
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED:
				getMaintained().clear();
				getMaintained().addAll((Collection<? extends Maintainable<GraphicsPipeline>>)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__DATA_PROVIDERS:
				getDataProviders().clear();
				getDataProviders().addAll((Collection<? extends GenericDataProvider<T>>)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG:
				setPresentationPkg((PresentationPkg)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER:
				setConstantBuffer((ConstantBuffer)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__BASIC_RESOURCES:
				getBasicResources().clear();
				getBasicResources().addAll((Collection<? extends DescriptedResource>)newValue);
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER:
				setPushBuffer((PushBuffer)newValue);
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
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED:
				getMaintained().clear();
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__DATA_PROVIDERS:
				getDataProviders().clear();
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG:
				setPresentationPkg((PresentationPkg)null);
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER:
				setConstantBuffer((ConstantBuffer)null);
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__BASIC_RESOURCES:
				getBasicResources().clear();
				return;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER:
				setPushBuffer((PushBuffer)null);
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
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED:
				return maintained != null && !maintained.isEmpty();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__DATA_PROVIDERS:
				return dataProviders != null && !dataProviders.isEmpty();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PRESENTATION_PKG:
				return presentationPkg != null;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__CONSTANT_BUFFER:
				return constantBuffer != null;
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__BASIC_RESOURCES:
				return basicResources != null && !basicResources.isEmpty();
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER__PUSH_BUFFER:
				return pushBuffer != null;
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
				case RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED: return MaintainerPackage.MAINTAINER__MAINTAINED;
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
				case MaintainerPackage.MAINTAINER__MAINTAINED: return RenderingPackage.GENERIC_RENDERER_MAINTAINER__MAINTAINED;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //GenericRendererMaintainerImpl
