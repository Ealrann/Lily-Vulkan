/**
 */
package org.sheepy.lily.vulkan.model.binding.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.binding.BindingPackage;
import org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite;
import org.sheepy.lily.vulkan.model.binding.EContextIndex;
import org.sheepy.lily.vulkan.model.process.PrepareCompositeTransfer;
import org.sheepy.lily.vulkan.model.resource.CompositeBuffer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configure Prepare Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl#getPrepareTask <em>Prepare Task</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl#getPartIndices <em>Part Indices</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.binding.impl.ConfigurePrepareCompositeImpl#getCompositeBuffer <em>Composite Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurePrepareCompositeImpl extends LilyEObject implements ConfigurePrepareComposite
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
	 * The cached value of the '{@link #getPrepareTask() <em>Prepare Task</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrepareTask()
	 * @generated
	 * @ordered
	 */
	protected PrepareCompositeTransfer prepareTask;

	/**
	 * The cached value of the '{@link #getPartIndices() <em>Part Indices</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartIndices()
	 * @generated
	 * @ordered
	 */
	protected EList<EContextIndex> partIndices;

	/**
	 * The cached value of the '{@link #getCompositeBuffer() <em>Composite Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeBuffer()
	 * @generated
	 * @ordered
	 */
	protected CompositeBuffer compositeBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurePrepareCompositeImpl()
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
		return BindingPackage.Literals.CONFIGURE_PREPARE_COMPOSITE;
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_PREPARE_COMPOSITE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrepareCompositeTransfer getPrepareTask()
	{
		if (prepareTask != null && ((EObject)prepareTask).eIsProxy())
		{
			InternalEObject oldPrepareTask = (InternalEObject)prepareTask;
			prepareTask = (PrepareCompositeTransfer)eResolveProxy(oldPrepareTask);
			if (prepareTask != oldPrepareTask)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK, oldPrepareTask, prepareTask));
			}
		}
		return prepareTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrepareCompositeTransfer basicGetPrepareTask()
	{
		return prepareTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrepareTask(PrepareCompositeTransfer newPrepareTask)
	{
		PrepareCompositeTransfer oldPrepareTask = prepareTask;
		prepareTask = newPrepareTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK, oldPrepareTask, prepareTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EContextIndex> getPartIndices()
	{
		if (partIndices == null)
		{
			partIndices = new EDataTypeUniqueEList<EContextIndex>(EContextIndex.class, this, BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PART_INDICES);
		}
		return partIndices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeBuffer getCompositeBuffer()
	{
		if (compositeBuffer != null && ((EObject)compositeBuffer).eIsProxy())
		{
			InternalEObject oldCompositeBuffer = (InternalEObject)compositeBuffer;
			compositeBuffer = (CompositeBuffer)eResolveProxy(oldCompositeBuffer);
			if (compositeBuffer != oldCompositeBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BindingPackage.CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER, oldCompositeBuffer, compositeBuffer));
			}
		}
		return compositeBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeBuffer basicGetCompositeBuffer()
	{
		return compositeBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompositeBuffer(CompositeBuffer newCompositeBuffer)
	{
		CompositeBuffer oldCompositeBuffer = compositeBuffer;
		compositeBuffer = newCompositeBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BindingPackage.CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER, oldCompositeBuffer, compositeBuffer));
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
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__NAME:
				return getName();
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK:
				if (resolve) return getPrepareTask();
				return basicGetPrepareTask();
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PART_INDICES:
				return getPartIndices();
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER:
				if (resolve) return getCompositeBuffer();
				return basicGetCompositeBuffer();
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
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__NAME:
				setName((String)newValue);
				return;
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK:
				setPrepareTask((PrepareCompositeTransfer)newValue);
				return;
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PART_INDICES:
				getPartIndices().clear();
				getPartIndices().addAll((Collection<? extends EContextIndex>)newValue);
				return;
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER:
				setCompositeBuffer((CompositeBuffer)newValue);
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
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK:
				setPrepareTask((PrepareCompositeTransfer)null);
				return;
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PART_INDICES:
				getPartIndices().clear();
				return;
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER:
				setCompositeBuffer((CompositeBuffer)null);
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
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PREPARE_TASK:
				return prepareTask != null;
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__PART_INDICES:
				return partIndices != null && !partIndices.isEmpty();
			case BindingPackage.CONFIGURE_PREPARE_COMPOSITE__COMPOSITE_BUFFER:
				return compositeBuffer != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", partIndices: ");
		result.append(partIndices);
		result.append(')');
		return result.toString();
	}

} //ConfigurePrepareCompositeImpl
