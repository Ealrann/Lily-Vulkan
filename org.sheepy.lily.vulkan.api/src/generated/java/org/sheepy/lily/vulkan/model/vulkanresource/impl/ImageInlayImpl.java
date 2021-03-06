/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Inlay</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl#getVerticalRelative <em>Vertical Relative</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageInlayImpl extends LilyEObject implements ImageInlay
{
	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected IVulkanImage image;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final Vector2ic POSITION_EDEFAULT = (Vector2ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector2i(), "0;0");

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Vector2ic position = POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final float SIZE_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected float size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHorizontalRelative() <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalRelative()
	 * @generated
	 * @ordered
	 */
	protected static final EHorizontalRelative HORIZONTAL_RELATIVE_EDEFAULT = EHorizontalRelative.LEFT;

	/**
	 * The cached value of the '{@link #getHorizontalRelative() <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalRelative()
	 * @generated
	 * @ordered
	 */
	protected EHorizontalRelative horizontalRelative = HORIZONTAL_RELATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerticalRelative() <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalRelative()
	 * @generated
	 * @ordered
	 */
	protected static final EVerticalRelative VERTICAL_RELATIVE_EDEFAULT = EVerticalRelative.TOP;

	/**
	 * The cached value of the '{@link #getVerticalRelative() <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalRelative()
	 * @generated
	 * @ordered
	 */
	protected EVerticalRelative verticalRelative = VERTICAL_RELATIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageInlayImpl()
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
		return VulkanResourcePackage.Literals.IMAGE_INLAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IVulkanImage getImage()
	{
		if (image != null && ((EObject)image).eIsProxy())
		{
			InternalEObject oldImage = (InternalEObject)image;
			image = (IVulkanImage)eResolveProxy(oldImage);
			if (image != oldImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.IMAGE_INLAY__IMAGE, oldImage, image));
			}
		}
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IVulkanImage basicGetImage()
	{
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImage(IVulkanImage newImage)
	{
		IVulkanImage oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_INLAY__IMAGE, oldImage, image));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector2ic getPosition()
	{
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(Vector2ic newPosition)
	{
		Vector2ic oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_INLAY__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(float newSize)
	{
		float oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_INLAY__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EHorizontalRelative getHorizontalRelative()
	{
		return horizontalRelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalRelative(EHorizontalRelative newHorizontalRelative)
	{
		EHorizontalRelative oldHorizontalRelative = horizontalRelative;
		horizontalRelative = newHorizontalRelative == null ? HORIZONTAL_RELATIVE_EDEFAULT : newHorizontalRelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_INLAY__HORIZONTAL_RELATIVE, oldHorizontalRelative, horizontalRelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EVerticalRelative getVerticalRelative()
	{
		return verticalRelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerticalRelative(EVerticalRelative newVerticalRelative)
	{
		EVerticalRelative oldVerticalRelative = verticalRelative;
		verticalRelative = newVerticalRelative == null ? VERTICAL_RELATIVE_EDEFAULT : newVerticalRelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_INLAY__VERTICAL_RELATIVE, oldVerticalRelative, verticalRelative));
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
			case VulkanResourcePackage.IMAGE_INLAY__IMAGE:
				if (resolve) return getImage();
				return basicGetImage();
			case VulkanResourcePackage.IMAGE_INLAY__POSITION:
				return getPosition();
			case VulkanResourcePackage.IMAGE_INLAY__SIZE:
				return getSize();
			case VulkanResourcePackage.IMAGE_INLAY__HORIZONTAL_RELATIVE:
				return getHorizontalRelative();
			case VulkanResourcePackage.IMAGE_INLAY__VERTICAL_RELATIVE:
				return getVerticalRelative();
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
			case VulkanResourcePackage.IMAGE_INLAY__IMAGE:
				setImage((IVulkanImage)newValue);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__POSITION:
				setPosition((Vector2ic)newValue);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__SIZE:
				setSize((Float)newValue);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__HORIZONTAL_RELATIVE:
				setHorizontalRelative((EHorizontalRelative)newValue);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__VERTICAL_RELATIVE:
				setVerticalRelative((EVerticalRelative)newValue);
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
			case VulkanResourcePackage.IMAGE_INLAY__IMAGE:
				setImage((IVulkanImage)null);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__HORIZONTAL_RELATIVE:
				setHorizontalRelative(HORIZONTAL_RELATIVE_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_INLAY__VERTICAL_RELATIVE:
				setVerticalRelative(VERTICAL_RELATIVE_EDEFAULT);
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
			case VulkanResourcePackage.IMAGE_INLAY__IMAGE:
				return image != null;
			case VulkanResourcePackage.IMAGE_INLAY__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case VulkanResourcePackage.IMAGE_INLAY__SIZE:
				return size != SIZE_EDEFAULT;
			case VulkanResourcePackage.IMAGE_INLAY__HORIZONTAL_RELATIVE:
				return horizontalRelative != HORIZONTAL_RELATIVE_EDEFAULT;
			case VulkanResourcePackage.IMAGE_INLAY__VERTICAL_RELATIVE:
				return verticalRelative != VERTICAL_RELATIVE_EDEFAULT;
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
		result.append(" (position: ");
		result.append(position);
		result.append(", size: ");
		result.append(size);
		result.append(", horizontalRelative: ");
		result.append(horizontalRelative);
		result.append(", verticalRelative: ");
		result.append(verticalRelative);
		result.append(')');
		return result.toString();
	}

} //ImageInlayImpl
