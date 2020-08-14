/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.vulkan.model.DescriptorPkg;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import org.sheepy.lily.vulkan.model.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPkg;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.TaskPipelineImpl#getVulkanResourcePkg <em>Vulkan Resource Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.TaskPipelineImpl#getDescriptorPkg <em>Descriptor Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.TaskPipelineImpl#getTaskPkgs <em>Task Pkgs</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TaskPipelineImpl extends AbstractPipelineImpl implements TaskPipeline
{
	/**
	 * The cached value of the '{@link #getVulkanResourcePkg() <em>Vulkan Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVulkanResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected VulkanResourcePkg vulkanResourcePkg;

	/**
	 * The cached value of the '{@link #getDescriptorPkg() <em>Descriptor Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorPkg()
	 * @generated
	 * @ordered
	 */
	protected DescriptorPkg descriptorPkg;

	/**
	 * The cached value of the '{@link #getTaskPkgs() <em>Task Pkgs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskPkgs()
	 * @generated
	 * @ordered
	 */
	protected EList<TaskPkg> taskPkgs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskPipelineImpl()
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
		return ProcessPackage.Literals.TASK_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VulkanResourcePkg getVulkanResourcePkg()
	{
		return vulkanResourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVulkanResourcePkg(VulkanResourcePkg newVulkanResourcePkg, NotificationChain msgs)
	{
		VulkanResourcePkg oldVulkanResourcePkg = vulkanResourcePkg;
		vulkanResourcePkg = newVulkanResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG, oldVulkanResourcePkg, newVulkanResourcePkg);
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
	public void setVulkanResourcePkg(VulkanResourcePkg newVulkanResourcePkg)
	{
		if (newVulkanResourcePkg != vulkanResourcePkg)
		{
			NotificationChain msgs = null;
			if (vulkanResourcePkg != null)
				msgs = ((InternalEObject)vulkanResourcePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG, null, msgs);
			if (newVulkanResourcePkg != null)
				msgs = ((InternalEObject)newVulkanResourcePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG, null, msgs);
			msgs = basicSetVulkanResourcePkg(newVulkanResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG, newVulkanResourcePkg, newVulkanResourcePkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorPkg getDescriptorPkg()
	{
		return descriptorPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorPkg(DescriptorPkg newDescriptorPkg, NotificationChain msgs)
	{
		DescriptorPkg oldDescriptorPkg = descriptorPkg;
		descriptorPkg = newDescriptorPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG, oldDescriptorPkg, newDescriptorPkg);
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
	public void setDescriptorPkg(DescriptorPkg newDescriptorPkg)
	{
		if (newDescriptorPkg != descriptorPkg)
		{
			NotificationChain msgs = null;
			if (descriptorPkg != null)
				msgs = ((InternalEObject)descriptorPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG, null, msgs);
			if (newDescriptorPkg != null)
				msgs = ((InternalEObject)newDescriptorPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG, null, msgs);
			msgs = basicSetDescriptorPkg(newDescriptorPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG, newDescriptorPkg, newDescriptorPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TaskPkg> getTaskPkgs()
	{
		if (taskPkgs == null)
		{
			taskPkgs = new EObjectContainmentEList<TaskPkg>(TaskPkg.class, this, ProcessPackage.TASK_PIPELINE__TASK_PKGS);
		}
		return taskPkgs;
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
			case ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG:
				return basicSetVulkanResourcePkg(null, msgs);
			case ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG:
				return basicSetDescriptorPkg(null, msgs);
			case ProcessPackage.TASK_PIPELINE__TASK_PKGS:
				return ((InternalEList<?>)getTaskPkgs()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG:
				return getVulkanResourcePkg();
			case ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG:
				return getDescriptorPkg();
			case ProcessPackage.TASK_PIPELINE__TASK_PKGS:
				return getTaskPkgs();
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
			case ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG:
				setVulkanResourcePkg((VulkanResourcePkg)newValue);
				return;
			case ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)newValue);
				return;
			case ProcessPackage.TASK_PIPELINE__TASK_PKGS:
				getTaskPkgs().clear();
				getTaskPkgs().addAll((Collection<? extends TaskPkg>)newValue);
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
			case ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG:
				setVulkanResourcePkg((VulkanResourcePkg)null);
				return;
			case ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG:
				setDescriptorPkg((DescriptorPkg)null);
				return;
			case ProcessPackage.TASK_PIPELINE__TASK_PKGS:
				getTaskPkgs().clear();
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
			case ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG:
				return vulkanResourcePkg != null;
			case ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG:
				return descriptorPkg != null;
			case ProcessPackage.TASK_PIPELINE__TASK_PKGS:
				return taskPkgs != null && !taskPkgs.isEmpty();
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
		if (baseClass == IResourceContainer.class)
		{
			switch (derivedFeatureID)
			{
				case ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG: return VulkanPackage.IRESOURCE_CONTAINER__VULKAN_RESOURCE_PKG;
				case ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG: return VulkanPackage.IRESOURCE_CONTAINER__DESCRIPTOR_PKG;
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
		if (baseClass == IResourceContainer.class)
		{
			switch (baseFeatureID)
			{
				case VulkanPackage.IRESOURCE_CONTAINER__VULKAN_RESOURCE_PKG: return ProcessPackage.TASK_PIPELINE__VULKAN_RESOURCE_PKG;
				case VulkanPackage.IRESOURCE_CONTAINER__DESCRIPTOR_PKG: return ProcessPackage.TASK_PIPELINE__DESCRIPTOR_PKG;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //TaskPipelineImpl
