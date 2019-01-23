/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachmentDescription;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.lily.vulkan.model.resource.DepthImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depth Attachment Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentDescriptionImpl#getDepthImage <em>Depth Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DepthAttachmentDescriptionImpl extends AttachmentDescriptionImpl implements DepthAttachmentDescription
{
	/**
	 * The cached value of the '{@link #getDepthImage() <em>Depth Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepthImage()
	 * @generated
	 * @ordered
	 */
	protected DepthImage depthImage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepthAttachmentDescriptionImpl()
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
		return GraphicPackage.Literals.DEPTH_ATTACHMENT_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DepthImage getDepthImage()
	{
		if (depthImage != null && depthImage.eIsProxy())
		{
			InternalEObject oldDepthImage = (InternalEObject)depthImage;
			depthImage = (DepthImage)eResolveProxy(oldDepthImage);
			if (depthImage != oldDepthImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE, oldDepthImage, depthImage));
			}
		}
		return depthImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepthImage basicGetDepthImage()
	{
		return depthImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthImage(DepthImage newDepthImage)
	{
		DepthImage oldDepthImage = depthImage;
		depthImage = newDepthImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE, oldDepthImage, depthImage));
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
			case GraphicPackage.DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE:
				if (resolve) return getDepthImage();
				return basicGetDepthImage();
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
			case GraphicPackage.DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE:
				setDepthImage((DepthImage)newValue);
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
			case GraphicPackage.DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE:
				setDepthImage((DepthImage)null);
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
			case GraphicPackage.DEPTH_ATTACHMENT_DESCRIPTION__DEPTH_IMAGE:
				return depthImage != null;
		}
		return super.eIsSet(featureID);
	}

} //DepthAttachmentDescriptionImpl
