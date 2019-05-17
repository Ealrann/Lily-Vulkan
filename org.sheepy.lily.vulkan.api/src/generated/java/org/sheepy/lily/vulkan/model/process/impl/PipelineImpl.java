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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.ResourcePkg;
import org.sheepy.lily.vulkan.model.VulkanPackage;
import org.sheepy.lily.vulkan.model.process.IProcessPart;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.enumeration.ECommandStage;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#getResourcePkg <em>Resource Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#getPushConstantRanges <em>Push Constant Ranges</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#getDescriptorSetRef <em>Descriptor Set Ref</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#getDescriptorSet <em>Descriptor Set</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelineImpl#getTaskPkg <em>Task Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelineImpl extends MinimalEObjectImpl.Container implements Pipeline
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourcePkg() <em>Resource Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcePkg()
	 * @generated
	 * @ordered
	 */
	protected ResourcePkg resourcePkg;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage STAGE_EDEFAULT = ECommandStage.RENDER;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected ECommandStage stage = STAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPushConstantRanges() <em>Push Constant Ranges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPushConstantRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<PushConstantRange> pushConstantRanges;

	/**
	 * The cached value of the '{@link #getDescriptorSetRef() <em>Descriptor Set Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSetRef()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSet descriptorSetRef;

	/**
	 * The cached value of the '{@link #getDescriptorSet() <em>Descriptor Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSet()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSet descriptorSet;

	/**
	 * The cached value of the '{@link #getTaskPkg() <em>Task Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskPkg()
	 * @generated
	 * @ordered
	 */
	protected TaskPkg taskPkg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipelineImpl()
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
		return ProcessPackage.Literals.PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePkg getResourcePkg()
	{
		return resourcePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourcePkg(ResourcePkg newResourcePkg, NotificationChain msgs)
	{
		ResourcePkg oldResourcePkg = resourcePkg;
		resourcePkg = newResourcePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ProcessPackage.PIPELINE__RESOURCE_PKG, oldResourcePkg, newResourcePkg);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResourcePkg(ResourcePkg newResourcePkg)
	{
		if (newResourcePkg != resourcePkg)
		{
			NotificationChain msgs = null;
			if (resourcePkg != null) msgs = ((InternalEObject) resourcePkg).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE__RESOURCE_PKG, null, msgs);
			if (newResourcePkg != null) msgs = ((InternalEObject) newResourcePkg).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE__RESOURCE_PKG, null, msgs);
			msgs = basicSetResourcePkg(newResourcePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE__RESOURCE_PKG, newResourcePkg, newResourcePkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECommandStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(ECommandStage newStage)
	{
		ECommandStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PushConstantRange> getPushConstantRanges()
	{
		if (pushConstantRanges == null)
		{
			pushConstantRanges = new EObjectContainmentEList<PushConstantRange>(
					PushConstantRange.class, this, ProcessPackage.PIPELINE__PUSH_CONSTANT_RANGES);
		}
		return pushConstantRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorSet getDescriptorSetRef()
	{
		if (descriptorSetRef != null && descriptorSetRef.eIsProxy())
		{
			InternalEObject oldDescriptorSetRef = (InternalEObject) descriptorSetRef;
			descriptorSetRef = (DescriptorSet) eResolveProxy(oldDescriptorSetRef);
			if (descriptorSetRef != oldDescriptorSetRef)
			{
				if (eNotificationRequired()) eNotify(new ENotificationImpl(this,
						Notification.RESOLVE, ProcessPackage.PIPELINE__DESCRIPTOR_SET_REF,
						oldDescriptorSetRef, descriptorSetRef));
			}
		}
		return descriptorSetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptorSet basicGetDescriptorSetRef()
	{
		return descriptorSetRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorSetRef(DescriptorSet newDescriptorSetRef)
	{
		DescriptorSet oldDescriptorSetRef = descriptorSetRef;
		descriptorSetRef = newDescriptorSetRef;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE__DESCRIPTOR_SET_REF, oldDescriptorSetRef,
				descriptorSetRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorSet getDescriptorSet()
	{
		return descriptorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorSet(	DescriptorSet newDescriptorSet,
													NotificationChain msgs)
	{
		DescriptorSet oldDescriptorSet = descriptorSet;
		descriptorSet = newDescriptorSet;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ProcessPackage.PIPELINE__DESCRIPTOR_SET, oldDescriptorSet, newDescriptorSet);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescriptorSet(DescriptorSet newDescriptorSet)
	{
		if (newDescriptorSet != descriptorSet)
		{
			NotificationChain msgs = null;
			if (descriptorSet != null) msgs = ((InternalEObject) descriptorSet).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE__DESCRIPTOR_SET, null, msgs);
			if (newDescriptorSet != null)
				msgs = ((InternalEObject) newDescriptorSet).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE__DESCRIPTOR_SET, null,
						msgs);
			msgs = basicSetDescriptorSet(newDescriptorSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE__DESCRIPTOR_SET, newDescriptorSet, newDescriptorSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TaskPkg getTaskPkg()
	{
		return taskPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTaskPkg(TaskPkg newTaskPkg, NotificationChain msgs)
	{
		TaskPkg oldTaskPkg = taskPkg;
		taskPkg = newTaskPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ProcessPackage.PIPELINE__TASK_PKG, oldTaskPkg, newTaskPkg);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTaskPkg(TaskPkg newTaskPkg)
	{
		if (newTaskPkg != taskPkg)
		{
			NotificationChain msgs = null;
			if (taskPkg != null) msgs = ((InternalEObject) taskPkg).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE__TASK_PKG, null, msgs);
			if (newTaskPkg != null) msgs = ((InternalEObject) newTaskPkg).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE - ProcessPackage.PIPELINE__TASK_PKG, null, msgs);
			msgs = basicSetTaskPkg(newTaskPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				ProcessPackage.PIPELINE__TASK_PKG, newTaskPkg, newTaskPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case ProcessPackage.PIPELINE__RESOURCE_PKG:
			return basicSetResourcePkg(null, msgs);
		case ProcessPackage.PIPELINE__PUSH_CONSTANT_RANGES:
			return ((InternalEList<?>) getPushConstantRanges()).basicRemove(otherEnd, msgs);
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET:
			return basicSetDescriptorSet(null, msgs);
		case ProcessPackage.PIPELINE__TASK_PKG:
			return basicSetTaskPkg(null, msgs);
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
		case ProcessPackage.PIPELINE__NAME:
			return getName();
		case ProcessPackage.PIPELINE__RESOURCE_PKG:
			return getResourcePkg();
		case ProcessPackage.PIPELINE__ENABLED:
			return isEnabled();
		case ProcessPackage.PIPELINE__STAGE:
			return getStage();
		case ProcessPackage.PIPELINE__PUSH_CONSTANT_RANGES:
			return getPushConstantRanges();
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET_REF:
			if (resolve) return getDescriptorSetRef();
			return basicGetDescriptorSetRef();
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET:
			return getDescriptorSet();
		case ProcessPackage.PIPELINE__TASK_PKG:
			return getTaskPkg();
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
		case ProcessPackage.PIPELINE__NAME:
			setName((String) newValue);
			return;
		case ProcessPackage.PIPELINE__RESOURCE_PKG:
			setResourcePkg((ResourcePkg) newValue);
			return;
		case ProcessPackage.PIPELINE__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case ProcessPackage.PIPELINE__STAGE:
			setStage((ECommandStage) newValue);
			return;
		case ProcessPackage.PIPELINE__PUSH_CONSTANT_RANGES:
			getPushConstantRanges().clear();
			getPushConstantRanges().addAll((Collection<? extends PushConstantRange>) newValue);
			return;
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET_REF:
			setDescriptorSetRef((DescriptorSet) newValue);
			return;
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET:
			setDescriptorSet((DescriptorSet) newValue);
			return;
		case ProcessPackage.PIPELINE__TASK_PKG:
			setTaskPkg((TaskPkg) newValue);
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
		case ProcessPackage.PIPELINE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ProcessPackage.PIPELINE__RESOURCE_PKG:
			setResourcePkg((ResourcePkg) null);
			return;
		case ProcessPackage.PIPELINE__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case ProcessPackage.PIPELINE__STAGE:
			setStage(STAGE_EDEFAULT);
			return;
		case ProcessPackage.PIPELINE__PUSH_CONSTANT_RANGES:
			getPushConstantRanges().clear();
			return;
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET_REF:
			setDescriptorSetRef((DescriptorSet) null);
			return;
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET:
			setDescriptorSet((DescriptorSet) null);
			return;
		case ProcessPackage.PIPELINE__TASK_PKG:
			setTaskPkg((TaskPkg) null);
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
		case ProcessPackage.PIPELINE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ProcessPackage.PIPELINE__RESOURCE_PKG:
			return resourcePkg != null;
		case ProcessPackage.PIPELINE__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case ProcessPackage.PIPELINE__STAGE:
			return stage != STAGE_EDEFAULT;
		case ProcessPackage.PIPELINE__PUSH_CONSTANT_RANGES:
			return pushConstantRanges != null && !pushConstantRanges.isEmpty();
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET_REF:
			return descriptorSetRef != null;
		case ProcessPackage.PIPELINE__DESCRIPTOR_SET:
			return descriptorSet != null;
		case ProcessPackage.PIPELINE__TASK_PKG:
			return taskPkg != null;
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
			case ProcessPackage.PIPELINE__RESOURCE_PKG:
				return VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG;
			default:
				return -1;
			}
		}
		if (baseClass == IProcessPart.class)
		{
			switch (derivedFeatureID)
			{
			default:
				return -1;
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
			case VulkanPackage.IRESOURCE_CONTAINER__RESOURCE_PKG:
				return ProcessPackage.PIPELINE__RESOURCE_PKG;
			default:
				return -1;
			}
		}
		if (baseClass == IProcessPart.class)
		{
			switch (baseFeatureID)
			{
			default:
				return -1;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", stage: ");
		result.append(stage);
		result.append(')');
		return result.toString();
	}

} //PipelineImpl
