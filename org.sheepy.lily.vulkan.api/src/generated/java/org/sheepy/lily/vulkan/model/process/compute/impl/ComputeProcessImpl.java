/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;

import org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl#getSourceEngine <em>Source Engine</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl#getExecutionRecorder <em>Execution Recorder</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputeProcessImpl extends AbstractProcessImpl implements ComputeProcess
{
	/**
	 * The cached value of the '{@link #getPipelinePkg() <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipelinePkg()
	 * @generated
	 * @ordered
	 */
	protected PipelinePkg pipelinePkg;

	/**
	 * The cached value of the '{@link #getSourceEngine() <em>Source Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEngine()
	 * @generated
	 * @ordered
	 */
	protected IEngine sourceEngine;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ComputeConfiguration configuration;

	/**
	 * The cached value of the '{@link #getExecutionRecorder() <em>Execution Recorder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionRecorder()
	 * @generated
	 * @ordered
	 */
	protected ComputeExecutionRecorder executionRecorder;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputeProcessImpl()
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
		return ComputePackage.Literals.COMPUTE_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelinePkg getPipelinePkg()
	{
		return pipelinePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPipelinePkg(PipelinePkg newPipelinePkg, NotificationChain msgs)
	{
		PipelinePkg oldPipelinePkg = pipelinePkg;
		pipelinePkg = newPipelinePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, oldPipelinePkg, newPipelinePkg);
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
	public void setPipelinePkg(PipelinePkg newPipelinePkg)
	{
		if (newPipelinePkg != pipelinePkg)
		{
			NotificationChain msgs = null;
			if (pipelinePkg != null)
				msgs = ((InternalEObject)pipelinePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, null, msgs);
			if (newPipelinePkg != null)
				msgs = ((InternalEObject)newPipelinePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, null, msgs);
			msgs = basicSetPipelinePkg(newPipelinePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, newPipelinePkg, newPipelinePkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IEngine getSourceEngine()
	{
		if (sourceEngine != null && ((EObject)sourceEngine).eIsProxy())
		{
			InternalEObject oldSourceEngine = sourceEngine;
			sourceEngine = (IEngine)eResolveProxy(oldSourceEngine);
			if (sourceEngine != oldSourceEngine)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputePackage.COMPUTE_PROCESS__SOURCE_ENGINE, oldSourceEngine, sourceEngine));
			}
		}
		return sourceEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IEngine basicGetSourceEngine()
	{
		return sourceEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceEngine(IEngine newSourceEngine)
	{
		IEngine oldSourceEngine = sourceEngine;
		sourceEngine = newSourceEngine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__SOURCE_ENGINE, oldSourceEngine, sourceEngine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputeConfiguration getConfiguration()
	{
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(ComputeConfiguration newConfiguration, NotificationChain msgs)
	{
		ComputeConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__CONFIGURATION, oldConfiguration, newConfiguration);
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
	public void setConfiguration(ComputeConfiguration newConfiguration)
	{
		if (newConfiguration != configuration)
		{
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputeExecutionRecorder getExecutionRecorder()
	{
		return executionRecorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExecutionRecorder(ComputeExecutionRecorder newExecutionRecorder, NotificationChain msgs)
	{
		ComputeExecutionRecorder oldExecutionRecorder = executionRecorder;
		executionRecorder = newExecutionRecorder;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER, oldExecutionRecorder, newExecutionRecorder);
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
	public void setExecutionRecorder(ComputeExecutionRecorder newExecutionRecorder)
	{
		if (newExecutionRecorder != executionRecorder)
		{
			NotificationChain msgs = null;
			if (executionRecorder != null)
				msgs = ((InternalEObject)executionRecorder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER, null, msgs);
			if (newExecutionRecorder != null)
				msgs = ((InternalEObject)newExecutionRecorder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER, null, msgs);
			msgs = basicSetExecutionRecorder(newExecutionRecorder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER, newExecutionRecorder, newExecutionRecorder));
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				return basicSetPipelinePkg(null, msgs);
			case ComputePackage.COMPUTE_PROCESS__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER:
				return basicSetExecutionRecorder(null, msgs);
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				return getPipelinePkg();
			case ComputePackage.COMPUTE_PROCESS__SOURCE_ENGINE:
				if (resolve) return getSourceEngine();
				return basicGetSourceEngine();
			case ComputePackage.COMPUTE_PROCESS__CONFIGURATION:
				return getConfiguration();
			case ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER:
				return getExecutionRecorder();
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)newValue);
				return;
			case ComputePackage.COMPUTE_PROCESS__SOURCE_ENGINE:
				setSourceEngine((IEngine)newValue);
				return;
			case ComputePackage.COMPUTE_PROCESS__CONFIGURATION:
				setConfiguration((ComputeConfiguration)newValue);
				return;
			case ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER:
				setExecutionRecorder((ComputeExecutionRecorder)newValue);
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)null);
				return;
			case ComputePackage.COMPUTE_PROCESS__SOURCE_ENGINE:
				setSourceEngine((IEngine)null);
				return;
			case ComputePackage.COMPUTE_PROCESS__CONFIGURATION:
				setConfiguration((ComputeConfiguration)null);
				return;
			case ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER:
				setExecutionRecorder((ComputeExecutionRecorder)null);
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				return pipelinePkg != null;
			case ComputePackage.COMPUTE_PROCESS__SOURCE_ENGINE:
				return sourceEngine != null;
			case ComputePackage.COMPUTE_PROCESS__CONFIGURATION:
				return configuration != null;
			case ComputePackage.COMPUTE_PROCESS__EXECUTION_RECORDER:
				return executionRecorder != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputeProcessImpl
