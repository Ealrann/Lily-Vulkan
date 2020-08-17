/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.resource.FileImage;

import org.sheepy.lily.vulkan.model.vulkanresource.FileImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Image Data Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.FileImageDataProviderImpl#getFileImageReference <em>File Image Reference</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.FileImageDataProviderImpl#getFileImageContainment <em>File Image Containment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FileImageDataProviderImpl extends ImageDataProviderImpl implements FileImageDataProvider
{
	/**
	 * The cached value of the '{@link #getFileImageReference() <em>File Image Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileImageReference()
	 * @generated
	 * @ordered
	 */
	protected FileImage fileImageReference;

	/**
	 * The cached value of the '{@link #getFileImageContainment() <em>File Image Containment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileImageContainment()
	 * @generated
	 * @ordered
	 */
	protected FileImage fileImageContainment;

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
	public FileImage getFileImageReference()
	{
		if (fileImageReference != null && ((EObject)fileImageReference).eIsProxy())
		{
			InternalEObject oldFileImageReference = (InternalEObject)fileImageReference;
			fileImageReference = (FileImage)eResolveProxy(oldFileImageReference);
			if (fileImageReference != oldFileImageReference)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE, oldFileImageReference, fileImageReference));
			}
		}
		return fileImageReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileImage basicGetFileImageReference()
	{
		return fileImageReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFileImageReference(FileImage newFileImageReference)
	{
		FileImage oldFileImageReference = fileImageReference;
		fileImageReference = newFileImageReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE, oldFileImageReference, fileImageReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FileImage getFileImageContainment()
	{
		return fileImageContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFileImageContainment(FileImage newFileImageContainment, NotificationChain msgs)
	{
		FileImage oldFileImageContainment = fileImageContainment;
		fileImageContainment = newFileImageContainment;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT, oldFileImageContainment, newFileImageContainment);
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
	public void setFileImageContainment(FileImage newFileImageContainment)
	{
		if (newFileImageContainment != fileImageContainment)
		{
			NotificationChain msgs = null;
			if (fileImageContainment != null)
				msgs = ((InternalEObject)fileImageContainment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT, null, msgs);
			if (newFileImageContainment != null)
				msgs = ((InternalEObject)newFileImageContainment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT, null, msgs);
			msgs = basicSetFileImageContainment(newFileImageContainment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT, newFileImageContainment, newFileImageContainment));
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT:
				return basicSetFileImageContainment(null, msgs);
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE:
				if (resolve) return getFileImageReference();
				return basicGetFileImageReference();
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT:
				return getFileImageContainment();
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE:
				setFileImageReference((FileImage)newValue);
				return;
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT:
				setFileImageContainment((FileImage)newValue);
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE:
				setFileImageReference((FileImage)null);
				return;
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT:
				setFileImageContainment((FileImage)null);
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
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_REFERENCE:
				return fileImageReference != null;
			case VulkanResourcePackage.FILE_IMAGE_DATA_PROVIDER__FILE_IMAGE_CONTAINMENT:
				return fileImageContainment != null;
		}
		return super.eIsSet(featureID);
	}

} //FileImageDataProviderImpl
