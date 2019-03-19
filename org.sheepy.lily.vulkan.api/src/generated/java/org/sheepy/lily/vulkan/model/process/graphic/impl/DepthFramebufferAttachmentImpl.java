/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.DepthFramebufferAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.lily.vulkan.model.resource.DepthImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depth Framebuffer Attachment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DepthFramebufferAttachmentImpl#isClear <em>Clear</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DepthFramebufferAttachmentImpl#getDepthImageRef <em>Depth Image Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DepthFramebufferAttachmentImpl extends MinimalEObjectImpl.Container
		implements DepthFramebufferAttachment
{
	/**
	 * The default value of the '{@link #isClear() <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClear()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CLEAR_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isClear() <em>Clear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isClear()
	 * @generated
	 * @ordered
	 */
	protected boolean clear = CLEAR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDepthImageRef() <em>Depth Image Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepthImageRef()
	 * @generated
	 * @ordered
	 */
	protected DepthImage depthImageRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepthFramebufferAttachmentImpl()
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
		return GraphicPackage.Literals.DEPTH_FRAMEBUFFER_ATTACHMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isClear()
	{
		return clear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClear(boolean newClear)
	{
		boolean oldClear = clear;
		clear = newClear;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__CLEAR, oldClear, clear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DepthImage getDepthImageRef()
	{
		if (depthImageRef != null && depthImageRef.eIsProxy())
		{
			InternalEObject oldDepthImageRef = (InternalEObject) depthImageRef;
			depthImageRef = (DepthImage) eResolveProxy(oldDepthImageRef);
			if (depthImageRef != oldDepthImageRef)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__DEPTH_IMAGE_REF,
							oldDepthImageRef, depthImageRef));
			}
		}
		return depthImageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepthImage basicGetDepthImageRef()
	{
		return depthImageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthImageRef(DepthImage newDepthImageRef)
	{
		DepthImage oldDepthImageRef = depthImageRef;
		depthImageRef = newDepthImageRef;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__DEPTH_IMAGE_REF, oldDepthImageRef,
				depthImageRef));
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
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__CLEAR:
			return isClear();
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__DEPTH_IMAGE_REF:
			if (resolve) return getDepthImageRef();
			return basicGetDepthImageRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__CLEAR:
			setClear((Boolean) newValue);
			return;
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__DEPTH_IMAGE_REF:
			setDepthImageRef((DepthImage) newValue);
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
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__CLEAR:
			setClear(CLEAR_EDEFAULT);
			return;
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__DEPTH_IMAGE_REF:
			setDepthImageRef((DepthImage) null);
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
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__CLEAR:
			return clear != CLEAR_EDEFAULT;
		case GraphicPackage.DEPTH_FRAMEBUFFER_ATTACHMENT__DEPTH_IMAGE_REF:
			return depthImageRef != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (clear: ");
		result.append(clear);
		result.append(')');
		return result.toString();
	}

} //DepthFramebufferAttachmentImpl
