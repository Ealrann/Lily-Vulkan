/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.vulkan.model.resource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Image Data Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.FileImageDataProviderImpl#getFileImage <em>File Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileImageDataProviderImpl extends ImageDataProviderImpl implements FileImageDataProvider
{
	/**
	 * The cached value of the '{@link #getFileImage() <em>File Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileImage()
	 * @generated
	 * @ordered
	 */
	protected FileImage fileImage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileImageDataProviderImpl()
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
		return VulkanResourcePackage.Literals.FILE_IMAGE_DATA_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileImage getFileImage()
	{
		if (fileImage != null && ((EObject)fileImage).eIsProxy())
		{
			InternalEObject oldFileImage = fileImage;
			fileImage = (FileImage)eResolveProxy(oldFileImage);
			if (fileImage != oldFileImage)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE, oldFileImage, fileImage));
			}
		}
		return fileImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileImage basicGetFileImage()
	{
		return fileImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFileImage(FileImage newFileImage)
	{
		FileImage oldFileImage = fileImage;
		fileImage = newFileImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE, oldFileImage, fileImage));
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE:
				if (resolve) return getFileImage();
				return basicGetFileImage();
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE:
				setFileImage((FileImage)newValue);
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE:
				setFileImage((FileImage)null);
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE:
				return fileImage != null;
		}
		return super.eIsSet(featureID);
	}

} //FileImageDataProviderImpl
