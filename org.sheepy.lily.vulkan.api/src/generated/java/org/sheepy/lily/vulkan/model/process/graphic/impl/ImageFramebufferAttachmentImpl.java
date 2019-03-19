/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.joml.Vector4f;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.ImageFramebufferAttachment;

import org.sheepy.lily.vulkan.model.resource.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Framebuffer Attachment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ImageFramebufferAttachmentImpl#getClearValue <em>Clear Value</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.ImageFramebufferAttachmentImpl#getImageRef <em>Image Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageFramebufferAttachmentImpl extends MinimalEObjectImpl.Container
		implements ImageFramebufferAttachment
{
	/**
	 * The default value of the '{@link #getClearValue() <em>Clear Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearValue()
	 * @generated
	 * @ordered
	 */
	protected static final Vector4f CLEAR_VALUE_EDEFAULT = (Vector4f) TypesFactory.eINSTANCE
			.createFromString(TypesPackage.eINSTANCE.getColor4f(), "0;0;0;0");
	/**
	 * The cached value of the '{@link #getClearValue() <em>Clear Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClearValue()
	 * @generated
	 * @ordered
	 */
	protected Vector4f clearValue = CLEAR_VALUE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getImageRef() <em>Image Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageRef()
	 * @generated
	 * @ordered
	 */
	protected Image imageRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageFramebufferAttachmentImpl()
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
		return GraphicPackage.Literals.IMAGE_FRAMEBUFFER_ATTACHMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector4f getClearValue()
	{
		return clearValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClearValue(Vector4f newClearValue)
	{
		Vector4f oldClearValue = clearValue;
		clearValue = newClearValue;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__CLEAR_VALUE, oldClearValue,
				clearValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image getImageRef()
	{
		if (imageRef != null && imageRef.eIsProxy())
		{
			InternalEObject oldImageRef = (InternalEObject) imageRef;
			imageRef = (Image) eResolveProxy(oldImageRef);
			if (imageRef != oldImageRef)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__IMAGE_REF, oldImageRef,
							imageRef));
			}
		}
		return imageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image basicGetImageRef()
	{
		return imageRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageRef(Image newImageRef)
	{
		Image oldImageRef = imageRef;
		imageRef = newImageRef;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__IMAGE_REF, oldImageRef, imageRef));
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
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__CLEAR_VALUE:
			return getClearValue();
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__IMAGE_REF:
			if (resolve) return getImageRef();
			return basicGetImageRef();
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
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__CLEAR_VALUE:
			setClearValue((Vector4f) newValue);
			return;
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__IMAGE_REF:
			setImageRef((Image) newValue);
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
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__CLEAR_VALUE:
			setClearValue(CLEAR_VALUE_EDEFAULT);
			return;
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__IMAGE_REF:
			setImageRef((Image) null);
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
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__CLEAR_VALUE:
			return CLEAR_VALUE_EDEFAULT == null
					? clearValue != null
					: !CLEAR_VALUE_EDEFAULT.equals(clearValue);
		case GraphicPackage.IMAGE_FRAMEBUFFER_ATTACHMENT__IMAGE_REF:
			return imageRef != null;
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
		result.append(" (clearValue: ");
		result.append(clearValue);
		result.append(')');
		return result.toString();
	}

} //ImageFramebufferAttachmentImpl
